package stanic.musixmatchwrapper.track.search

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("header")
class TrackSearchResultMessage(
    val body: TrackSearchResultBody
)