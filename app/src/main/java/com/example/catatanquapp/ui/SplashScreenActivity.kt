package com.example.catatanquapp.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.catatanquapp.MainActivity
import com.example.catatanquapp.R
import com.example.catatanquapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.apply {
            this.startLayoutAnimation()

            addTransitionListener(object : MotionLayout.TransitionListener{
                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int
                ) {

                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {

                }

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float
                ) {
                }

            })

        }
    }

//        // text to set in textView
//        val mText = "CatatanQu."
//
//        // creating spannable string form normal string
//        // we will use it to apply the text color to subString
//        val mSpannableString = SpannableString(mText)
//
//        // color styles to apply on subString
//        val mYellow = ForegroundColorSpan(Color.YELLOW)
//
//        // applying color styles to subString
//        mSpannableString.setSpan(mYellow, 29, 30, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
//
//        // setting text to the textView
//        binding.textView.text = mSpannableString
}