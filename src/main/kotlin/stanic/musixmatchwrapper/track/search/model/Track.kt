package stanic.musixmatchwrapper.track.search.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("album_coverart_350x350", "album_coverart_500x500", "first_release_date", "track_isrc", "track_soundcloud_id", "album_coverart_800x800", "album_coverart_100x100", "has_subtitles", "subtitle_id", "has_richsync", "track_spotify_id", "artist_mbid", "track_xboxmusic_id", "track_length", "track_mbid", "commontrack_id", "num_favourite", "secondary_genres")
class TrackBase(
    @JsonProperty("track_id") val trackId: Int,
    @JsonProperty("track_name") val trackName: String,
    @JsonProperty("track_name_translation_list") val nameTranslationList: List<String>,
    @JsonProperty("track_rating") val rating: Int,
    @JsonProperty("instrumental") val instrumental: Int,
    @JsonProperty("explicit") val explicit: Int,
    @JsonProperty("has_lyrics") val hasLyrics: Int,
    @JsonProperty("album_id") val albumId: Int,
    @JsonProperty("album_name") val albumName: String,
    @JsonProperty("artist_id") val artistId: Int,
    @JsonProperty("artist_name") val artistName: String,
    @JsonProperty("track_share_url") val trackShareUrl: String,
    @JsonProperty("track_edit_url") val trackEditUrl: String,
    @JsonProperty("restricted") val restricted: Int,
    @JsonProperty("updated_time") val updatedTime: String,
    @JsonProperty("primary_genres") val primaryGenres: MusicGenreList
) {

    fun get() = Track(trackId, trackName, nameTranslationList, rating, instrumental == 1, explicit == 1, hasLyrics == 1, albumId, albumName, artistId, artistName, trackShareUrl, trackEditUrl, restricted == 1, updatedTime, primaryGenres)

}

class Track(
    val trackId: Int,
    val trackName: String,
    val nameTranslationList: List<String>,
    val rating: Int,
    val instrumental: Boolean,
    val explicit: Boolean,
    val hasLyrics: Boolean,
    val albumId: Int,
    val albumName: String,
    val artistId: Int,
    val artistName: String,
    val trackShareUrl: String,
    val trackEditUrl: String,
    val restricted: Boolean,
    val updatedTime: String,
    val primaryGenres: MusicGenreList
)