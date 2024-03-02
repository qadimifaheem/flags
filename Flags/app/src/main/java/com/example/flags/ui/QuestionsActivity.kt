package com.example.flags.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.flags.R
import com.example.flags.model.Questions
import com.example.flags.utlis.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textvprogress: TextView
    private lateinit var textquestions: TextView
    private lateinit var flagimage: ImageView
    private lateinit var checkButton: Button

    private lateinit var textop1: TextView
    private lateinit var textop2: TextView
    private lateinit var textop3: TextView
    private lateinit var textop4: TextView
    private var currentPosition = 0
    private lateinit var questionsList: MutableList<Questions>


    private var questionCounter = 0

    private var selectedAnswer = 0
    private lateinit var currentQuestion: Questions
    private var answered = false
    private lateinit var name : String
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)



        progressBar = findViewById(R.id.progressbar)
        textvprogress = findViewById(R.id.progress)
        textquestions = findViewById(R.id.question)
        flagimage = findViewById(R.id.imageflag)
        checkButton = findViewById(R.id.buttoncheck)

        textop1 = findViewById(R.id.options1)
        textop2 = findViewById(R.id.options2)
        textop3 = findViewById(R.id.options3)
        textop4 = findViewById(R.id.options4)


        textop1.setOnClickListener(this)
        textop2.setOnClickListener(this)
        textop3.setOnClickListener(this)
        textop4.setOnClickListener(this)
        checkButton.setOnClickListener(this)



        questionsList = Constants.getQuestions()
        Log.d("Question size", "${questionsList.size}")
        showNextQuestion()

        if (intent.hasExtra(Constants.UserName))
        {
            name = intent.getStringExtra(Constants.UserName)!!
        }
    }


    private fun showNextQuestion() {

        if (questionCounter < questionsList.size)
        {
            currentQuestion = questionsList[questionCounter]
            checkButton.text = "Check"

            resetoptions()
            val question = questionsList[currentPosition]
            flagimage.setImageResource(question.image)
            progressBar.progress = questionCounter
            textvprogress.text = "${questionCounter + 1}/${progressBar.max}"
            textquestions.text = question.questions
            textop1.text = question.option1
            textop2.text = question.option2
            textop3.text = question.option3
            textop4.text = question.option4
        }
        else
        {
            checkButton.text = "Finish"

            Intent(this@QuestionsActivity,ResultActivity::class.java).also{
                it.putExtra(Constants.UserName,name)
                it.putExtra(Constants.score,score)
                it.putExtra(Constants.total_questions,questionsList.size)

                startActivity(it)
            }
        }
        questionCounter++
        answered = false

    }

    private fun resetoptions() {
        val options = mutableListOf<TextView>()

        options.add(textop1)
        options.add(textop2)
        options.add(textop3)
        options.add(textop4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.optionselected)
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetoptions()


        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this, R.drawable.optionselected
        )
        selectedAnswer = selectedOptionNumber
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.options1 -> {
                selectedOption(textop1, 1)
            }

            R.id.options2 -> {
                selectedOption(textop2, 2)
            }

            R.id.options3 -> {
                selectedOption(textop3, 3)
            }

            R.id.options4 -> {
                selectedOption(textop4, 4)
            }


            R.id.buttoncheck -> {

                if (!answered) {
                    checkAnswer()
                } else {
                    answered = false
                    currentPosition++
                    showNextQuestion()
                }
                selectedAnswer = 0
            }
        }
    }

    private fun checkAnswer() {
        answered = true

        if (selectedAnswer == currentQuestion.correct)
        {
            score++
            highlightAnswer(selectedAnswer)

        }
        else
        {
            when (selectedAnswer) {
                1 -> {
                    textop1.background = ContextCompat.getDrawable(this, R.drawable.wrongoption)
                }

                2 -> {
                    textop2.background = ContextCompat.getDrawable(this, R.drawable.wrongoption)
                }

                3 -> {
                    textop3.background = ContextCompat.getDrawable(this, R.drawable.wrongoption)
                }

                4 -> {
                    textop4.background = ContextCompat.getDrawable(this, R.drawable.wrongoption)
                }
            }
        }
        checkButton.text = "Next"
        showSolution()
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correct
        highlightAnswer(selectedAnswer)
    }
    private fun highlightAnswer(answer : Int)
    {
        when (answer) {
            1 -> {
                textop1.background = ContextCompat.getDrawable(this, R.drawable.correctoptionborder)
            }

            2 -> {
                textop2.background = ContextCompat.getDrawable(this, R.drawable.correctoptionborder)
            }

            3 -> {
                textop3.background = ContextCompat.getDrawable(this, R.drawable.correctoptionborder)
            }

            4 -> {
                textop4.background = ContextCompat.getDrawable(this, R.drawable.correctoptionborder)
            }
        }
    }
}
