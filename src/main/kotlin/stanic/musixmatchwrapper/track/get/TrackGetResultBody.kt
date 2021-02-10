package stanic.musixmatchwrapper.track.get

import com.fasterxml.jackson.annotation.JsonProperty
import stanic.musixmatchwrapper.track.model.TrackBase

class TrackGetResultBody(
    @JsonProperty("track") val track: TrackBase
)