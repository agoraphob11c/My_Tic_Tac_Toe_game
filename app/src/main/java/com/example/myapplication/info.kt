package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.myapplication.TicTacToe
import com.example.myapplication.databinding.ActivityInfoBinding
import com.example.myapplication.databinding.ActivityTicTacToeBinding

class info : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            val intent = Intent(this, TicTacToe::class.java)
            startActivity(intent)
        }


    }
}