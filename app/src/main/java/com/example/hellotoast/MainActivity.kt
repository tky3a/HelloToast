package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.btn_roll)
        val resultText : TextView = findViewById(R.id.textView2)
        val btnCntUp : Button = findViewById(R.id.btnCntUp)
        btnCntUp.isEnabled = false
        rollButton.setOnClickListener {
            val randomInt = (1..6).random()
            resultText.text = randomInt.toString()
            // ROLLがタップされたタイミングでtrue
            btnCntUp.isEnabled = true
            rollDice()
        }
        btnCntUp.setOnClickListener {
            val currentText = resultText.text.toString().toIntOrNull()
            // nullではなく、int型の時に発火
            if (currentText != null) {
                var num = resultText.text.toString().toInt()
                num++
                resultText.text = num.toString()
            }
        }
    }

    private fun rollDice() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }
}