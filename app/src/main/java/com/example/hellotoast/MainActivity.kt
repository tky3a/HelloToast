package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    // ※初期化遅延 lateinitで初期化するタイミングを指定できる（null許容として扱える）
    // 自動的に初回はnullになる
    private lateinit var diceImage : ImageView
    private lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ROLLボタン押下
        val rollButton : Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener {
            rollDice()
        }

        // ※ここで初期化を行う！view取得
        diceImage = findViewById(R.id.diceImage1)
        diceImage2 = findViewById(R.id.diceImage2)
        // クリアボタンのView取得
        val clearBtn: Button = findViewById(R.id.btnClear)
        // クリアボタン押下
        clearBtn.setOnClickListener {
            diceClear(diceImage, diceImage2)
        }
    }

    // Rollボタン発火関数
    private fun rollDice() {
        // ２つのダイスを回す
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()

        // whenで画像データをランダムで設定
        return when (randomInt) {
            1 -> R.drawable.dice_1 // R.drawableでdrawableディレクトリを参照している
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun diceClear(diceImage:ImageView,diceImage2:ImageView ) {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }
}