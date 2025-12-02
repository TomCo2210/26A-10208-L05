package dev.tomco.a26a_10208_l05.utilities

import dev.tomco.a26a_10208_l05.model.Playlist
import dev.tomco.a26a_10208_l05.model.Song
import java.time.LocalDate

object DataManager {
    fun generatePlaylist(): Playlist{
        return Playlist
            .Builder()
            .name("Top Three!")
            .addSong(
                Song
                    .Builder()
                    .name("Scar Tissue")
                    .artist("Red Hot Chili Peppers")
                    .durationInSeconds(220)
                    .views(589_756_674L)
                    .tags(listOf("Rock","Alternative"))
                    .releaseDate(LocalDate.of(2011,7,11).toEpochDay())
                    .build()
            )
            .addSong(
                Song
                    .Builder()
                    .name("מכה אפורה")
                    .artist("מוניקה סקס")
                    .durationInSeconds(255)
                    .views(5_221_111L)
                    .releaseDate(LocalDate.of(2009,12,17).toEpochDay())
                    .tags(listOf("ישראלי","רוק","פלורנטין"))
                    .build()
            )
            .addSong(
                Song
                    .Builder()
                    .name("יוניקורן")
                    .artist("נועה קירל")
                    .durationInSeconds(192)
                    .views(9_957_564L)
                    .releaseDate(LocalDate.of(2023,3,8).toEpochDay())
                    .tags(listOf("ישראלי","פופ","אירוויזיון"))
                    .build()
            )
            .build()


    }
}