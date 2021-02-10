package stanic.musixmatchwrapper.track.lyrics

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("header")
class LyricsGetResultMessage(
    @JsonProperty("body") val body: LyricsGetResultBody
)