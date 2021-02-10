<h1 align="center"><img src="https://store-images.s-microsoft.com/image/apps.16561.9007199266242800.c2f92b79-2545-460a-8a6f-93324399d636.ba6c52de-76af-4b98-b269-83b98e856064" width="800"></h1>

<p align="center">
    Musixmatch api wrapper written in Kotlin <br><br>
    <a>
        <img src="https://img.shields.io/static/v1?label=build&message=none&color=red"
        alt="Build">
    </a>
</p>

## 📒 Usage

- 🔎 **For more info visit** [MusixMatch api documentation](https://developer.musixmatch.com/documentation)

- **Declare Musixmatch instance**:
```kotlin
val musixMatch = MusixMatch("apiKey")
```

- **Searching for a track**:
```kotlin
/**
* Parameters: track, artist, artistId, lyrics, track_artist, hasLyrics
*
* @return List<Track>
**/
musixMatch.searchTrack("track name")
```

- **Getting a track by common id**:
```kotlin
/**
* Parameters: common track id
*
* @return Track or null if can't find anything
**/
musixMatch.getTrack(commonTrackId)
```

## 🔨 Still in development
Soon new information about
