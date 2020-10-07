package com.dicoding.rumahkost.desy_githubuser_submission_i

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var latar = object : Thread() {
            override fun run() {
                try {
                    sleep(4000)
                    val pindah = Intent(baseContext, MenuUtama::class.java)
                    startActivity(pindah)
                    this@MainActivity.finish()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        latar.start()
    }
}
