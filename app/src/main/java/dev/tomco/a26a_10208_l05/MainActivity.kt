package dev.tomco.a26a_10208_l05

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.google.gson.Gson
import dev.tomco.a26a_10208_l05.model.Playlist
import dev.tomco.a26a_10208_l05.utilities.Constants
import dev.tomco.a26a_10208_l05.utilities.DataManager
import dev.tomco.a26a_10208_l05.utilities.ImageLoader
import dev.tomco.a26a_10208_l05.utilities.SharedPreferencesManagerV1
import dev.tomco.a26a_10208_l05.utilities.SharedPreferencesManagerV2
import dev.tomco.a26a_10208_l05.utilities.SharedPreferencesManagerV3
import dev.tomco.a26a_10208_l05.utilities.SignalManager

class MainActivity : AppCompatActivity() {

    private lateinit var main_IMG_background: AppCompatImageView

    private lateinit var main_LBL_json: MaterialTextView

    private lateinit var main_BTN_toastAndVibrate: MaterialButton

    private lateinit var main_BTN_loadImage: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViews()
        initViews()

        sharedPreferencesExample()

    }

    private fun sharedPreferencesExample() {
        //create a playlist:
//        val playlist: Playlist = DataManager.generatePlaylist()
//        Log.d("Playlist Object:", playlist.toString())

        //Convert To Json:
        val gson = Gson()

//        val playlistAsJson: String = gson.toJson(playlist)
//        Log.d("Playlist As Json:", playlistAsJson)


        //Save To SP v1:
//        SharedPreferencesManagerV1.putString(
//            this,
//            Constants.SP_KEYS.PLAYLIST_KEY,
//            playlistAsJson
//        )

        //Load From SP v1:
//        val playlistFromSP: String =
//            SharedPreferencesManagerV1.getString(
//                this,
//                Constants.SP_KEYS.PLAYLIST_KEY,
//                ""
//            )
//        Log.d("PlaylistFromSP As Json:", playlistFromSP)
//        val regeneratedPlaylist = gson.fromJson(
//            playlistFromSP,
//            Playlist::class.java
//        )
//        Log.d("PlaylistFromSP As Object:", regeneratedPlaylist.toString())

        //Load from SP v2:
//        val playlistFromSP: String =
//            SharedPreferencesManagerV2(this).getString(
//                Constants.SP_KEYS.PLAYLIST_KEY,
//                ""
//            )
//        Log.d("PlaylistFromSP As Json:", playlistFromSP)
//        val regeneratedPlaylist = gson.fromJson(
//            playlistFromSP,
//            Playlist::class.java
//        )
//        Log.d("PlaylistFromSP As Object:", regeneratedPlaylist.toString())

        //Load from SP v3:
        val playlistFromSP: String =
            SharedPreferencesManagerV3
                .getInstance()
                .getString(
                Constants.SP_KEYS.PLAYLIST_KEY,
                ""
            )
        Log.d("PlaylistFromSP As Json:", playlistFromSP)
        val regeneratedPlaylist = gson.fromJson(
            playlistFromSP,
            Playlist::class.java
        )
        Log.d("PlaylistFromSP As Object:", regeneratedPlaylist.toString())
    }

    private fun findViews() {
        main_IMG_background = findViewById(R.id.main_IMG_background)
        main_LBL_json = findViewById(R.id.main_LBL_json)
        main_BTN_toastAndVibrate = findViewById(R.id.main_BTN_toastAndVibrate)
        main_BTN_loadImage = findViewById(R.id.main_BTN_loadImage)
    }

    private fun initViews() {

        ImageLoader.getInstance()
            .loadImage(
                R.drawable.zebras,
                main_IMG_background
                )


        main_BTN_loadImage.setOnClickListener {
            ImageLoader.getInstance()
                .loadImage(
                    "https://cdn.pixabay.com/photo/2025/07/16/10/33/rice-9717641_1280.jpg",
                    main_IMG_background
                )
        }

        main_BTN_toastAndVibrate.setOnClickListener { view ->
            SignalManager
                .getInstance()
                .toast(
                    "Hello World!🌍",
                    SignalManager.ToastLength.SHORT)
            SignalManager
                .getInstance()
                .vibrate()

        }
    }
}