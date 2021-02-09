package stanic.musixmatchwrapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import retrofit2.*
import retrofit2.converter.jackson.JacksonConverterFactory
import stanic.musixmatchwrapper.track.TrackService
import stanic.musixmatchwrapper.track.search.TrackSearchResult
import stanic.musixmatchwrapper.track.search.model.Track

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

    fun searchTrack(track: String, artist: String = "", artistId: String = "", lyrics: String = "", track_artist: String = "", hasLyrics: Boolean = false, callback: (Track?) -> Unit) {
        val trackService = service.create(TrackService::class.java)

        trackService.searchTrack(apiKey, track, artist, artistId, lyrics, track_artist, if (hasLyrics) 1.0 else 0.0).enqueue(object : Callback<TrackSearchResult> {
            override fun onResponse(call: Call<TrackSearchResult>, response: Response<TrackSearchResult>) {
                when (response.code()) {
                    401 -> callback(null).apply { Throwable("Authentication failed, probably because of invalid/missing API key").printStackTrace() }
                    402 -> callback(null).apply { Throwable("The usage limit has been reached").printStackTrace() }
                    403 -> callback(null).apply { Throwable("You are not authorized to perform this operation").printStackTrace() }
                    404, 405 -> callback(null).apply { Throwable("Not found").printStackTrace() }
                    500, 400 -> callback(null).apply { Throwable("Something were wrong").printStackTrace() }
                    503 -> callback(null).apply { Throwable("Musixmatch system is a bit busy at the moment and your request can’t be satisfied").printStackTrace() }
                    else -> {
                        if (response.body() == null || response.body()!!.message.body.trackList.isEmpty()) callback(null).apply { Throwable("Not found").printStackTrace() }
                        else callback(response.body()!!.message.body.trackList[0].track.get())
                    }
                }
            }

            override fun onFailure(call: Call<TrackSearchResult>, throwable: Throwable) {
                throwable.printStackTrace()
                callback(null)
            }
        })
    }

}