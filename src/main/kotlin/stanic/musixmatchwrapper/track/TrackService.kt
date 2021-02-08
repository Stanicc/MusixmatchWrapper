package stanic.musixmatchwrapper.track

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import stanic.musixmatchwrapper.track.search.TrackSearchResult
import stanic.musixmatchwrapper.track.search.TrackSearchResultMessage

interface TrackService {

    @GET("track.search")
    fun searchTrack(
        @Query("apikey") apiKey: String,
        @Query("q_track") track: String,
        @Query("q_artist") artist: String = "",
        @Query("f_artist_id") artistId: String = "",
        @Query("q_lyrics") lyrics: String = "",
        @Query("q_track_artist") track_artist: String = "",
        @Query("f_has_lyrics") hasLyrics: Double = 1.0
    ) : Call<TrackSearchResult>

}