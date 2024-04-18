package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.myapplication.TicTacToe
import kotlin.random.Random
import android.view.View
import android.widget.Button
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    public var moveCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            val intent = Intent(this, TicTacToe::class.java)  //this I took from skillfactori coures where I also studied Android programming
            startActivity(intent)
        }
        startButton()
    }



    fun startButton() {  //lai varētu sākt spēli

        binding.moveName.text = "Let's start the game"
        binding.button1.text = ""
        binding.button2.text = ""
        binding.button3.text = ""
        binding.button4.text = ""
        binding.button5.text = ""
        binding.button6.text = ""
        binding.button7.text = ""
        binding.button8.text = ""
        binding.button9.text = ""

        moveCounter = 0

        binding.buttonReplayGame.visibility = View.GONE
        binding.buttonStartGame.visibility = View.VISIBLE

        binding.buttonStartGame.setOnClickListener{
            binding.button1.isEnabled = true
            binding.button2.isEnabled = true
            binding.button3.isEnabled = true
            binding.button4.isEnabled = true
            binding.button5.isEnabled = true
            binding.button6.isEnabled = true
            binding.button7.isEnabled = true
            binding.button8.isEnabled = true
            binding.button9.isEnabled = true

            binding.buttonStartGame.visibility = View.GONE
            playerMove()
        }

    }

    fun  playerMove() { //funkcija, kas nodrošina iespēju zināt, kura spēlētāja gājiens šobrīd tiek veikts
        if(moveCounter>=4){
            moveCounter +=1
            if(moveCounter % 2 == 1){
                binding.moveName.text = "X turn"
            }else{
                binding.moveName.text = "O turn"
            }
            addings()
        }else {
            moveCounter += 1
            if (moveCounter % 2 == 1) {
                binding.moveName.text = "X turn"
            } else {
                binding.moveName.text = "O turn"
            }
            simpleAdd()
        }
    }


    fun checkWinCondition() { //funkcija, lai nevajadzētu rakstīt visu šo tekstu pēc katra gājiena, bet izcaukt funkciju checkwincondition
        var winCheck = true


        if(binding.button1.text == binding.button2.text && binding.button2.text == binding.button3.text && binding.button1.text.isNotEmpty()){
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button1.text + " WON"
        }else if(binding.button4.text == binding.button5.text && binding.button5.text == binding.button6.text && binding.button6.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button4.text + " WON"
        }else if(binding.button7.text == binding.button8.text && binding.button8.text == binding.button9.text && binding.button9.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button7.text + " WON"
        }else if(binding.button1.text == binding.button4.text && binding.button4.text == binding.button7.text && binding.button7.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button1.text + " WON"
        }else if(binding.button2.text == binding.button5.text && binding.button5.text == binding.button8.text && binding.button8.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button2.text + " WON"
        }else if(binding.button3.text == binding.button6.text && binding.button6.text == binding.button9.text && binding.button9.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button3.text + " WON"
        }else if(binding.button1.text == binding.button5.text && binding.button5.text == binding.button9.text && binding.button9.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button1.text + " WON"
        }else if(binding.button3.text == binding.button5.text && binding.button5.text == binding.button7.text && binding.button7.text.isNotEmpty()) {
            winCheck = false
            binding.moveName.text = "PLAYER " + binding.button3.text + " WON"
        }else if(binding.button1.text.isNotEmpty() && binding.button2.text.isNotEmpty() && binding.button3.text.isNotEmpty() && binding.button4.text.isNotEmpty() && binding.button5.text.isNotEmpty() && binding.button6.text.isNotEmpty() && binding.button7.text.isNotEmpty() && binding.button8.text.isNotEmpty() && binding.button9.text.isNotEmpty()){
            winCheck = false
            binding.moveName.text = "NOBODY WON" }



        if(winCheck){
            playerMove() // ja nav uzvara, tad turpina spēli
        }else{
            replayGame() //ja uzvara tad spēles beigas

        }

    }

    fun replayGame() {
        binding.erText.text = "You can't put it here"
        binding.erText.visibility = View.INVISIBLE
        binding.buttonReplayGame.visibility = View.VISIBLE
        binding.button1.isEnabled = false
        binding.button2.isEnabled = false
        binding.button3.isEnabled = false
        binding.button4.isEnabled = false
        binding.button5.isEnabled = false
        binding.button6.isEnabled = false
        binding.button7.isEnabled = false
        binding.button8.isEnabled = false
        binding.button9.isEnabled = false


        binding.buttonReplayGame.setOnClickListener {
            startButton()
        }
    }

    fun addings() { //funkcija, kas npieciešama lai random veidā izvēlētos kāda dabība būs izsaukta
        var randomNr = Random.nextInt(12) //stackOwerfloy someone asked how to make random numbers
        when(randomNr){
            0,1,2,3,4,5 -> simpleAdd() // 50% chance
            6,7,8 -> deleteItem() //25%
            9,10 -> changeItem() //17%
            11 -> undeletableItem() // 8%
        }
    }

    fun simpleAdd (){
        binding.erText.visibility = View.VISIBLE
        binding.erText.text = "Put your item in spot"
        binding.button1.setOnClickListener { onClickButAdd(binding.button1) }
        binding.button2.setOnClickListener { onClickButAdd(binding.button2) }
        binding.button3.setOnClickListener { onClickButAdd(binding.button3) }
        binding.button4.setOnClickListener { onClickButAdd(binding.button4) }
        binding.button5.setOnClickListener { onClickButAdd(binding.button5) }
        binding.button6.setOnClickListener { onClickButAdd(binding.button6) }
        binding.button7.setOnClickListener { onClickButAdd(binding.button7) }
        binding.button8.setOnClickListener { onClickButAdd(binding.button8) }
        binding.button9.setOnClickListener { onClickButAdd(binding.button9) }
    }
    
    fun deleteItem(): Int {
        var countOfX = listOf(binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9).count { it.text=="X" && it.isEnabled} //chatGPT helped me to write this part, cause i didn't know how to count how many  X and O I have

        var countOfO = listOf(binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9).count{ it.text == "O" && it.isEnabled} //also chatGPT but this i wrote by my self, but chat helped me for first time

        binding.erText.visibility = View.VISIBLE
        binding.erText.text = "Delete any item you want"
        binding.button1.setOnClickListener { onClickButDel(binding.button1, countOfX, countOfO) }
        binding.button2.setOnClickListener { onClickButDel(binding.button2, countOfX, countOfO) }
        binding.button3.setOnClickListener { onClickButDel(binding.button3, countOfX, countOfO) }
        binding.button4.setOnClickListener { onClickButDel(binding.button4, countOfX, countOfO) }
        binding.button5.setOnClickListener { onClickButDel(binding.button5, countOfX, countOfO) }
        binding.button6.setOnClickListener { onClickButDel(binding.button6, countOfX, countOfO) }
        binding.button7.setOnClickListener { onClickButDel(binding.button7, countOfX, countOfO) }
        binding.button8.setOnClickListener { onClickButDel(binding.button8, countOfX, countOfO) }
        binding.button9.setOnClickListener { onClickButDel(binding.button9, countOfX, countOfO) }


        return countOfX; countOfO
    }

    fun changeItem() {
        var countOfX = listOf(binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9).count { it.text=="X" && it.isEnabled}

        var countOfO = listOf(binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9).count{ it.text == "O" && it.isEnabled}

        if(countOfO == 0 && binding.moveName.text == "X turn"){
            simpleAdd()
        }

        if(countOfX == 0 && binding.moveName.text == "O turn"){
            simpleAdd()
        }

        binding.erText.visibility = View.VISIBLE
        binding.erText.text = "Change any item to other"
        binding.button1.setOnClickListener { onClickButCh(binding.button1) }
        binding.button2.setOnClickListener { onClickButCh(binding.button2) }
        binding.button3.setOnClickListener { onClickButCh(binding.button3) }
        binding.button4.setOnClickListener { onClickButCh(binding.button4) }
        binding.button5.setOnClickListener { onClickButCh(binding.button5) }
        binding.button6.setOnClickListener { onClickButCh(binding.button6) }
        binding.button7.setOnClickListener { onClickButCh(binding.button7) }
        binding.button8.setOnClickListener { onClickButCh(binding.button8) }
        binding.button9.setOnClickListener { onClickButCh(binding.button9)  }
    }

    fun undeletableItem() {

        var countOfX = listOf(binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9).count { it.text=="X" && it.isEnabled}

        var countOfO = listOf(binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9).count{ it.text == "O" && it.isEnabled}

        if(countOfO == 0 && binding.moveName.text == "O turn"){
            simpleAdd()
        }

        if(countOfX == 0 && binding.moveName.text == "X turn"){
            simpleAdd()
        }

        binding.erText.text = "Make your item undel!"
        binding.erText.visibility = View.VISIBLE
        binding.button1.setOnClickListener { onClickButUD(binding.button1) }
        binding.button2.setOnClickListener { onClickButUD(binding.button2) }
        binding.button3.setOnClickListener { onClickButUD(binding.button3) }
        binding.button4.setOnClickListener { onClickButUD(binding.button4) }
        binding.button5.setOnClickListener { onClickButUD(binding.button5) }
        binding.button6.setOnClickListener { onClickButUD(binding.button6) }
        binding.button7.setOnClickListener { onClickButUD(binding.button7) }
        binding.button8.setOnClickListener { onClickButUD(binding.button8) }
        binding.button9.setOnClickListener { onClickButUD(binding.button9) }
        
    }

    fun onClickButAdd(buttonNr: Button) {
        if (buttonNr.text.isEmpty()) {
            if (binding.moveName.text.toString() == "X turn") buttonNr.text = "X" else buttonNr.text = "O"
            checkWinCondition()
        } else {
            binding.erText.text = "You can't put it here"
            binding.erText.visibility = View.VISIBLE
            simpleAdd()
        }
    }

    fun onClickButDel(buttonNr : Button, countOfX : Int, countOfO : Int) {

        if(countOfX == 0){
            simpleAdd()
        } else if(buttonNr.text == "X" && binding.moveName.text == "O turn"){
            buttonNr.text = ""
            checkWinCondition()
        }

        if(countOfO == 0) {
            simpleAdd()
        } else if(buttonNr.text == "O" && binding.moveName.text == "X turn") {
            buttonNr.text = ""
            checkWinCondition()
        }
    }
    
    fun onClickButCh(buttonNr : Button){
        changeItem()
        if(buttonNr.text == "X" && binding.moveName.text == "O turn"){
            buttonNr.text = "O"
            checkWinCondition()
        }else if(buttonNr.text == "O" && binding.moveName.text == "X turn") {
            buttonNr.text = "X"
            checkWinCondition()
        }


    }

    fun onClickButUD(buttonNr : Button){

        if(buttonNr.text == "X" && binding.moveName.text == "X turn"){
            buttonNr.isEnabled = false
            checkWinCondition()
        }
        if(buttonNr.text == "O" && binding.moveName.text == "O turn") {
            buttonNr.isEnabled = false
            checkWinCondition()
        }
    }

    fun playGame() {
        binding.erText.visibility = View.INVISIBLE
        binding.button1.setOnClickListener { onClickButAdd(binding.button1) } //chatGPT helped me to make function onClickButAdd,
        binding.button2.setOnClickListener { onClickButAdd(binding.button2) } //I didn't know how to make function which can take
        binding.button3.setOnClickListener { onClickButAdd(binding.button3) } //button name that was clicked
        binding.button4.setOnClickListener { onClickButAdd(binding.button4) } //and send it to function
        binding.button5.setOnClickListener { onClickButAdd(binding.button5) }
        binding.button6.setOnClickListener { onClickButAdd(binding.button6) }
        binding.button7.setOnClickListener { onClickButAdd(binding.button7) }
        binding.button8.setOnClickListener { onClickButAdd(binding.button8) }
        binding.button9.setOnClickListener { onClickButAdd(binding.button9) }
        }


}
