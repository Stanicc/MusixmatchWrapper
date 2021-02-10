package stanic.musixmatchwrapper.track.model

import com.fasterxml.jackson.annotation.JsonProperty

class MusicGenre(
    @JsonProperty("music_genre") val genre: GenreModel
)

class GenreModel(
    @JsonProperty("music_genre_id") val genreId: Int,
    @JsonProperty("music_genre_parent_id") val genreParentId: Int,
    @JsonProperty("music_genre_name") val genreName: String,
    @JsonProperty("music_genre_name_extended") val genreNameExtended: String,
    @JsonProperty("music_genre_vanity") val genreVanity: String
)