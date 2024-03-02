package com.example.flags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.flags.ui.QuestionsActivity
import com.example.flags.utlis.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start : Button = findViewById(R.id.start)
        val edittextName : EditText = findViewById(R.id.name)

        start.setOnClickListener {
            if (!edittextName.text.isEmpty())
            {
                Intent(this@MainActivity,QuestionsActivity::class.java).also {
                    it.putExtra(Constants.UserName,edittextName.text.toString())
                    startActivity(it)
                    finish()
                }
            }
            else
            {
                Toast.makeText(this@MainActivity,"Please Enter your name",Toast.LENGTH_LONG).show()
            }
        }

    }
}