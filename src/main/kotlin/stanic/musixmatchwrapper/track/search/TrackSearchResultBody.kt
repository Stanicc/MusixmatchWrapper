package stanic.musixmatchwrapper.track.search

import com.fasterxml.jackson.annotation.JsonProperty

class TrackSearchResultBody(
    @JsonProperty("track_list") val trackList: List<TrackSearchResultTrack>
)