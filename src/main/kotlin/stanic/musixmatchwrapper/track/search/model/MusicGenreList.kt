package stanic.musixmatchwrapper.track.search.model

import com.fasterxml.jackson.annotation.JsonProperty

class MusicGenreList(
    @JsonProperty("music_genre_list") val musicGenreList: List<MusicGenre>
)