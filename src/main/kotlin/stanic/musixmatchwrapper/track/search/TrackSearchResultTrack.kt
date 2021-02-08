package stanic.musixmatchwrapper.track.search

import com.fasterxml.jackson.annotation.JsonProperty
import stanic.musixmatchwrapper.track.search.model.Track

class TrackSearchResultTrack(
    @JsonProperty("track") val track: Track
)