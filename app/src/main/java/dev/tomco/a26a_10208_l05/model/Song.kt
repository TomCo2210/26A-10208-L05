package dev.tomco.a26a_10208_l05.model

data class Song private constructor(
    val name: String,
    val artist: String,
    val durationInSeconds: Int,
    val views: Long,
    val tags: List<String>,
    val releaseDate: Long
) {
    class Builder(
        var name: String = "",
        var artist: String = "",
        var durationInSeconds: Int = 0,
        var views: Long = 0L,
        var tags: List<String> = mutableListOf(),
        var releaseDate: Long = 0L
    ) {
        fun name(name: String) = apply { this.name = name }
        fun artist(artist: String) = apply { this.artist = artist }
        fun durationInSeconds(durationInSeconds: Int) =
            apply { this.durationInSeconds = durationInSeconds }

        fun views(views: Long) = apply { this.views = views }
        fun tags(tags: List<String>) = apply { this.tags = tags }
        fun releaseDate(releaseDate: Long) = apply { this.releaseDate = releaseDate }
        fun build() = Song(
            name,
            artist,
            durationInSeconds,
            views,
            tags,
            releaseDate
        )
    }
}