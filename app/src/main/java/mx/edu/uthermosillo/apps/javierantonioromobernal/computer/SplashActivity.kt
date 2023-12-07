package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashactivity)

        Handler().postDelayed({
            val i = Intent(this, CompActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)
    }
}