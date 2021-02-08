package stanic.musixmatchwrapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import stanic.musixmatchwrapper.track.TrackService
import stanic.musixmatchwrapper.track.search.TrackSearchResultBody

class MusixMatch(
    val apiKey: String
) {

    var service: Retrofit
    private val baseUrl = "https://api.musixmatch.com/ws/1.1/"

    init {
        service = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerKotlinModule()))
            .build()
    }

    fun searchTrack(track: String, artist: String = "", artistId: String = "", lyrics: String = "", track_artist: String = "", hasLyrics: Boolean = false): TrackSearchResultBody? {
        val trackService = service.create(TrackService::class.java)

        val callback = trackService.searchTrack(apiKey, track, artist, artistId, lyrics, track_artist, if (hasLyrics) 1.0 else 0.0).execute()
        if (!callback.isSuccessful) return null

        return callback.body()!!.message.body
    }

}