package stanic.musixmatchwrapper.track.search

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class TrackSearchResult(
    val message: TrackSearchResultMessage
)