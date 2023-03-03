package com.example.cusctomclock

import android.annotation.SuppressLint
import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cusctomclock.databinding.CustomClockBinding
import java.text.SimpleDateFormat
import java.util.*


class CustomClock @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = CustomClockBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                @SuppressLint("SimpleDateFormat")
                val dateFormat = SimpleDateFormat("HH:mm:ss")
                val date = dateFormat.format(Date()).split(":")
                val hours = date[0].toInt() * 30F
                val minutes = date[1].toInt() * 6F
                val seconds = date[2].toInt() * 6F

                binding.hours.rotation = hours
                binding.minutes.rotation = minutes
                binding.seconds.rotation = seconds
                start()
            }
        }.start()
    }
}