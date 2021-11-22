package com.example.tikdavaleba


import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private lateinit var btn7 : Button
    private lateinit var btn8 : Button
    private lateinit var btn9 : Button
    private lateinit var resetButton : Button
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private lateinit var menu : Button
    private lateinit var filledpos : IntArray
    var gameActive = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        init()
    }

    private fun init() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        menu = findViewById(R.id.menu)
        resetButton = findViewById(R.id.resetButton)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)

        menu.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }

        resetButton.setOnClickListener() {
            restartGame()
        }
    }

    override fun onClick(clickedView: View?) {
        var buttonNumber = 0
        if (clickedView is Button) {
            when (clickedView.id){
                R.id.btn1 -> buttonNumber = 1
                R.id.btn2 -> buttonNumber = 2
                R.id.btn3 -> buttonNumber = 3
                R.id.btn4 -> buttonNumber = 4
                R.id.btn5 -> buttonNumber = 5
                R.id.btn6 -> buttonNumber = 6
                R.id.btn7 -> buttonNumber = 7
                R.id.btn8 -> buttonNumber = 8
                R.id.btn9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setPositiveButton("თამაშის თავიდან დაწყება!", DialogInterface.OnClickListener { dialog, which ->
                restartGame()
            })
            .show()

    }



    private fun playGame (clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setTextColor(Color.BLACK)
            clickedView.backgroundTintList = getColorStateList(R.color.purple_200)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }
        else {
            clickedView.text = "0"
            clickedView.backgroundTintList = getColorStateList(R.color.teal_700)
            clickedView.setTextColor(Color.BLACK)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check() {
        var winnerPlayer = 0
        if (!btn1.isEnabled &&! btn2.isEnabled &&! btn3.isEnabled &&! btn4.isEnabled
            &&! btn5.isEnabled &&! btn6.isEnabled &&! btn1.isEnabled &&! btn7.isEnabled
            &&! btn8.isEnabled &&! btn9.isEnabled && winnerPlayer ==0){
            winnerPlayer = 3
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            showMessage ("პირველმა მოთამაშემ მოიგო!")
            stopTouch()
        }
        else if (winnerPlayer == 2) {
            showMessage ("მეორე მოთამაშემ მოიგო!")
            stopTouch()
        }
        else if (winnerPlayer == 3) {
            showMessage ("თამაში არის ფრე!")
            stopTouch()
        }

    }

    private fun stopTouch()
    {
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btn4.isEnabled = false
        btn5.isEnabled = false
        btn6.isEnabled = false
        btn7.isEnabled = false
        btn8.isEnabled = false
        btn9.isEnabled = false
    }


    private fun restartGame() {
        filledpos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
        activePlayer = 1
        gameActive = true
        btn1.setText("")
        btn2.setText("")
        btn3.setText("")
        btn4.setText("")
        btn5.setText("")
        btn6.setText("")
        btn7.setText("")
        btn8.setText("")
        btn9.setText("")

        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1

        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true

        btn1.backgroundTintList = getColorStateList(R.color.purple_500)
        btn2.backgroundTintList = getColorStateList(R.color.purple_500)
        btn3.backgroundTintList = getColorStateList(R.color.purple_500)
        btn4.backgroundTintList = getColorStateList(R.color.purple_500)
        btn5.backgroundTintList = getColorStateList(R.color.purple_500)
        btn6.backgroundTintList = getColorStateList(R.color.purple_500)
        btn7.backgroundTintList = getColorStateList(R.color.purple_500)
        btn8.backgroundTintList = getColorStateList(R.color.purple_500)
        btn9.backgroundTintList = getColorStateList(R.color.purple_500)

    }
}