package edu.arbyfebrian.valorantagentpedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // Durasi tampilan Splash Screen (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val imageView: ImageView = findViewById(R.id.imageView)

        imageView.setOnClickListener {
            showPopup()
        }


        // Delay untuk beberapa detik sebelum pindah ke MainActivity
        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup SplashScreen agar tidak dapat dikembalikan dengan tombol kembali
        }, SPLASH_TIME_OUT)
    }

    private fun showPopup() {
        val popupView = layoutInflater.inflate(R.layout.popup_layout, null)
        val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val createdByTextView: TextView = popupView.findViewById(R.id.textViewCreatedBy)
        createdByTextView.text = "Congratulations! you found an Easter Egg!  \n Created By: Arby Febrian Saputro"
        val imageView: ImageView = findViewById(R.id.imageView)
        popupWindow.showAtLocation(imageView, Gravity.TOP, 0, 400)
    }
}