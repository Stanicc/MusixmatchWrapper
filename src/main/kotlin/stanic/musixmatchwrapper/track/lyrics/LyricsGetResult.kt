package stanic.musixmatchwrapper.track.lyrics

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class LyricsGetResult(
    val message: LyricsGetResultMessage
)