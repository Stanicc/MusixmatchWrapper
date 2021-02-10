package stanic.musixmatchwrapper.track.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @params can be null or default values because the return of the body can be different between tracks
 *
 * @get method return the Track class (Formatted)
 */
class TrackBase(
    @JsonProperty("track_id") val trackId: Int,
    @JsonProperty("commontrack_id") val commonTrackId: Int,
    @JsonProperty("commontrack_vanity_id") val commonTrackVanityId: String? = null,
    @JsonProperty("track_name") val trackName: String,
    @JsonProperty("track_mbid") val trackMbid: String? = null,
    @JsonProperty("track_length") val track_length: Int = 0,
    @JsonProperty("track_isrc") val trackISRC: String? = null,
    @JsonProperty("track_soundcloud_id") val trackSoundcloudId: Int = 0,
    @JsonProperty("track_xboxmusic_id") val trackXboxMusicId: String? = null,
    @JsonProperty("track_spotify_id") val track_spotify_id: String? = null,
    @JsonProperty("track_name_translation_list") val nameTranslationList: List<String> = listOf(),
    @JsonProperty("track_rating") val rating: Int = 0,
    @JsonProperty("num_favourite") val favouriteAmount: Int = 0,
    @JsonProperty("instrumental") val instrumental: Int = 0,
    @JsonProperty("explicit") val explicit: Int = 0,
    @JsonProperty("restricted") val restricted: Int = 0,
    @JsonProperty("has_lyrics") val hasLyrics: Int = 0,
    @JsonProperty("has_subtitles") val hasSubtitles: Int = 0,
    @JsonProperty("has_richsync") val hasRychSync: Int = 0,
    @JsonProperty("album_id") val albumId: Int,
    @JsonProperty("album_name") val albumName: String,
    @JsonProperty("album_coverart_100x100") val albumCoverArt100x100: String? = null,
    @JsonProperty("album_coverart_350x350") val albumCoverArt350x350: String? = null,
    @JsonProperty("album_coverart_500x500") val albumCoverArt500x500: String? = null,
    @JsonProperty("album_coverart_800x800") val albumCoverArt800x800: String? = null,
    @JsonProperty("artist_id") val artistId: Int,
    @JsonProperty("artist_name") val artistName: String,
    @JsonProperty("artist_mbid") val artistMbid: String? = null,
    @JsonProperty("lyrics_id") val lyrics_id: Int = 0,
    @JsonProperty("subtitle_id") val subTitleId: Int = 0,
    @JsonProperty("track_share_url") val trackShareUrl: String,
    @JsonProperty("track_edit_url") val trackEditUrl: String,
    @JsonProperty("updated_time") val updatedTime: String,
    @JsonProperty("first_release_date") val firstReleaseDate: String? = null,
    @JsonProperty("primary_genres") val primaryGenres: MusicGenreList,
    @JsonProperty("secondary_genres") val secondaryGenres: MusicGenreList? = null
) {

    fun get() = Track(trackId, commonTrackId, commonTrackVanityId, trackName, trackMbid, track_length, trackISRC, trackSoundcloudId, trackXboxMusicId, track_spotify_id, nameTranslationList, rating, favouriteAmount, instrumental == 1, explicit == 1, restricted == 1, hasLyrics == 1, hasSubtitles == 1, hasRychSync == 1, albumId, albumName, albumCoverArt100x100, albumCoverArt350x350, albumCoverArt500x500, albumCoverArt800x800, artistId, artistName, artistMbid, lyrics_id, subTitleId, trackShareUrl, trackEditUrl, updatedTime, firstReleaseDate, primaryGenres, secondaryGenres)

}

class Track(
    val trackId: Int,
    val commonTrackId: Int,
    val commonTrackVanityId: String? = null,
    val trackName: String,
    val trackMbid: String? = null,
    val track_length: Int = 0,
    val trackISRC: String? = null,
    val trackSoundcloudId: Int = 0,
    val trackXboxMusicId: String? = null,
    val track_spotify_id: String? = null,
    val nameTranslationList: List<String> = listOf(),
    val rating: Int = 0,
    val favouriteAmount: Int = 0,
    val instrumental: Boolean,
    val explicit: Boolean,
    val restricted: Boolean,
    val hasLyrics: Boolean,
    val hasSubtitles: Boolean,
    val hasRychSync: Boolean,
    val albumId: Int,
    val albumName: String,
    val albumCoverArt100x100: String? = null,
    val albumCoverArt350x350: String? = null,
    val albumCoverArt500x500: String? = null,
    val albumCoverArt800x800: String? = null,
    val artistId: Int,
    val artistName: String,
    val artistMbid: String? = null,
    val lyrics_id: Int = 0,
    val subTitleId: Int = 0,
    val trackShareUrl: String,
    val trackEditUrl: String,
    val updatedTime: String,
    val firstReleaseDate: String? = null,
    val primaryGenres: MusicGenreList,
    val secondaryGenres: MusicGenreList? = null
)