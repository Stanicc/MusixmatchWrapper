package stanic.musixmatchwrapper.track.lyrics

import com.fasterxml.jackson.annotation.JsonProperty
import stanic.musixmatchwrapper.track.model.LyricsBase

class LyricsGetResultBody(
    @JsonProperty("lyrics") val lyrics: LyricsBase
)