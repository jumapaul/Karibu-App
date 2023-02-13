package com.pauljuma.karibuapp.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pauljuma.karibuapp.databinding.ActivityAuthenticationBinding

@SuppressLint("CustomSplashScreen")
class Authentication : AppCompatActivity() {

    lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}