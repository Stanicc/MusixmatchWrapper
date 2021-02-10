package stanic.musixmatchwrapper.track.get

import com.fasterxml.jackson.annotation.JsonAutoDetect

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class TrackGetResult(
    val message: TrackGetResultMessage
)