package com.example.cusctomclock

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cusctomclock.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Добавление custom view через код
        val mainLayout = findViewById<ConstraintLayout>(R.id.second_layout)
        val newClock = CustomClock(this)
        newClock.layoutParams = ActionBar.LayoutParams(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )
        mainLayout.addView(newClock)

        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}