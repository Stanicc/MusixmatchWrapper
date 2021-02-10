package stanic.musixmatchwrapper.track.get

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("header")
class TrackGetResultMessage(
    @JsonProperty("body") val body: TrackGetResultBody
)