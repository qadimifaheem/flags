package com.example.flags.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.flags.MainActivity
import com.example.flags.R
import com.example.flags.utlis.Constants

class ResultActivity : AppCompatActivity() {


    private lateinit var textViewScore : TextView
    private lateinit var textViewName : TextView
    private lateinit var finishButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewScore = findViewById(R.id.tv_score)
        textViewName  = findViewById(R.id.tv_name)
        finishButton = findViewById(R.id.finishButton)


        val totalquestions = intent.getIntExtra(Constants.total_questions,0)
        val score = intent.getIntExtra(Constants.score,0)
        val name = intent.getStringExtra(Constants.UserName)


        textViewScore.text = "Your score is $score out of $totalquestions"
        textViewName.text = name
        finishButton.setOnClickListener{
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}