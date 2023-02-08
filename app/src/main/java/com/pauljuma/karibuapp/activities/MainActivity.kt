package com.pauljuma.karibuapp.activities

import android.app.TaskStackBuilder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pauljuma.karibuapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
           // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
           // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
           // startActivity(intent)

            TaskStackBuilder.create(applicationContext).addNextIntentWithParentStack(intent).startActivities()
        }, 1000)


    }
}
