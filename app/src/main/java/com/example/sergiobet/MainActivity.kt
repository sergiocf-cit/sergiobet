package com.example.sergiobet

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rotater()
        scaler()

        Handler().postDelayed({
            startActivity(Intent(this,LoginActivity::class.java))

            finish()
        }, 6000)

    }

    private fun rotater() {
        val ball = findViewById<ImageView>(R.id.ball)

        val animator = ObjectAnimator.ofFloat(ball, View.ROTATION, -360f, 1620f)
        animator.duration = 6000

        animator.start()
    }

    private fun scaler() {
        val slogan = findViewById<TextView>(R.id.sergio_bet)

        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(slogan, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = 3000
        animator.start()
    }
}
