package stanic.musixmatchwrapper.track.search

import com.fasterxml.jackson.annotation.JsonProperty
import stanic.musixmatchwrapper.track.model.TrackBase

class TrackSearchResultTrack(
    @JsonProperty("track") val track: TrackBase
)