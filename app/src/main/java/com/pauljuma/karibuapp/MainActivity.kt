package com.pauljuma.karibuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.database.AppDatabase
import com.pauljuma.karibuapp.repository.KaribuRepository
import com.pauljuma.karibuapp.viewmodel.KaribuViewModel
import com.pauljuma.karibuapp.viewmodel.KaribuViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var karibuViewModel: KaribuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val karibuRepository = KaribuRepository(AppDatabase(this))
        val karibuViewModelFactory = KaribuViewModelFactory(karibuRepository)

        karibuViewModel =
            ViewModelProvider(this, karibuViewModelFactory).get(KaribuViewModel::class.java)
    }
}