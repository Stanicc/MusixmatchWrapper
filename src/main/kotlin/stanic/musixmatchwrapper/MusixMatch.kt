package stanic.musixmatchwrapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.jackson.JacksonConverterFactory
import stanic.musixmatchwrapper.track.TrackService
import stanic.musixmatchwrapper.track.model.Track
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class MusixMatch(
    private val apiKey: String
) {

    var service: Retrofit
    private val baseUrl = "https://api.musixmatch.com/ws/1.1/"

    init {
        service = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerKotlinModule()))
            .build()
    }

    fun searchTrack(track: String, artist: String = "", artistId: String = "", lyrics: String = "", track_artist: String = "", hasLyrics: Boolean = false): List<Track> {
        val trackService = service.create(TrackService::class.java)
        val response = GlobalScope.async { execute(trackService.searchTrack(apiKey, track, artist, artistId, lyrics, track_artist, if (hasLyrics) 1.0 else 0.0)) }

        return runBlocking {
            val result = response.await()

            if (result == null || result.message.body.trackList.isEmpty()) arrayListOf()
            else {
                val tracks = ArrayList<Track>()
                for (it in result.message.body.trackList) tracks.add(it.track.get())

                tracks
            }
        }
    }

    fun getTrack(commonTrackId: Int): Track? {
        val trackService = service.create(TrackService::class.java)
        val response = GlobalScope.async { execute(trackService.getTrack(apiKey, commonTrackId)) }

        return runBlocking {
            val result = response.await()
            result?.message?.body?.track?.get()
        }
    }

    private suspend fun <T> execute(call: Call<T>): T? {
        return suspendCancellableCoroutine { continuation: CancellableContinuation<T?> ->
            call.enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    when (response.code()) {
                        401 -> continuation.resumeWithException(Throwable("Authentication failed, probably because of invalid/missing API key"))
                        402 -> continuation.resumeWithException(Throwable("The usage limit has been reached"))
                        403 -> continuation.resumeWithException(Throwable("You are not authorized to perform this operation"))
                        404, 405 -> continuation.resumeWithException(Throwable("Not found"))
                        500, 400 -> continuation.resumeWithException(Throwable("Something were wrong"))
                        503 -> continuation.resumeWithException(Throwable("Musixmatch system is a bit busy at the moment and your request can’t be satisfied"))
                        else -> continuation.resume(response.body())
                    }
                }
                override fun onFailure(call: Call<T>, throwable: Throwable) {
                    throwable.printStackTrace()
                    continuation.resume(null)
                }
            })
        }
    }

}