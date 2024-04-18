package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.myapplication.MainActivity
import com.example.myapplication.info
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityTicTacToeBinding

class TicTacToe : AppCompatActivity() {
    private lateinit var binding: ActivityTicTacToeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonStartGame1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.infoButton.setOnClickListener {
            val intent2 = Intent(this, info::class.java)
            startActivity(intent2)
        }

    }
}


