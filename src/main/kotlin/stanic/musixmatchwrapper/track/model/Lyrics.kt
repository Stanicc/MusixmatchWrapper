package stanic.musixmatchwrapper.track.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @params can be null or default values because the return of the body can be different between tracks
 *
 * @get method return the Lyrics class (Formatted)
 */
class LyricsBase(
    @JsonProperty("lyrics_id") val lyricsId: Int,
    @JsonProperty("lyrics_language") val lyricsLanguage: String? = null,
    @JsonProperty("lyrics_language_description") val lyricsLanguageDescription: String? = null,
    @JsonProperty("lyrics_copyright") val lyricsCopyright: String,
    @JsonProperty("lyrics_body") val lyricsBody: String,
    @JsonProperty("updated_time") val updatedTime: String,
    @JsonProperty("verified") val verified: Int = 0,
    @JsonProperty("explicit") val explicit: Int = 0,
    @JsonProperty("instrumental") val instrumental: Int = 0,
    @JsonProperty("restricted") val restricted: Int = 0,
    @JsonProperty("can_edit") val canEdit: Int = 0,
    @JsonProperty("locked") val locked: Int = 0,
    @JsonProperty("action_requested") val actionRequested: String? = null,
    @JsonProperty("publisher_list") val publisherList: List<String> = listOf(),
    @JsonProperty("writer_list") val writerList: List<String> = listOf(),
    @JsonProperty("pixel_tracking_url") val pixelTrackingUrl: String,
    @JsonProperty("script_tracking_url") val scriptTrackingUrl: String,
    @JsonProperty("html_tracking_url") val htmlTrackingUrl: String? = null
) {

    fun get() = Lyrics(lyricsId, lyricsLanguage, lyricsLanguageDescription, lyricsCopyright, lyricsBody, updatedTime, verified == 1, explicit == 1, instrumental == 1, restricted == 1, canEdit == 1, locked == 1, actionRequested, publisherList, writerList, pixelTrackingUrl, scriptTrackingUrl, htmlTrackingUrl)

}

class Lyrics(
    val lyricsId: Int,
    val lyricsLanguage: String? = null,
    val lyricsLanguageDescription: String? = null,
    val lyricsCopyright: String,
    val lyricsBody: String,
    val updatedTime: String,
    val verified: Boolean,
    val explicit: Boolean,
    val instrumental: Boolean,
    val restricted: Boolean,
    val canEdit: Boolean,
    val locked: Boolean,
    val actionRequested: String? = null,
    val publisherList: List<String> = listOf(),
    val writerList: List<String> = listOf(),
    val pixelTrackingUrl: String,
    val scriptTrackingUrl: String,
    val htmlTrackingUrl: String? = null
)