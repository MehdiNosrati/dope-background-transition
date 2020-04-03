package io.mns.dope_background_transition

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import io.mns.dope_background_transition.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var nextColor: Int = Color.WHITE
    private var lastColor: Int = Color.WHITE
    private val timerTask = object : TimerTask() {
        override fun run() {
            nextColor = generateColor()
            binding.root.animateColor(lastColor, nextColor, 3600)
            lastColor = nextColor
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        startTransition()
    }

    private fun startTransition() {
        Timer().scheduleAtFixedRate(timerTask, 300, 3600)
    }

    fun View.animateColor(from: Int, to: Int, duration: Long) {
        runOnUiThread {
            val animation =
                ValueAnimator.ofObject(ArgbEvaluator(), from, to)
            animation.duration = duration
            animation.addUpdateListener {
                setBackgroundColor(it.animatedValue as Int)
            }
            animation.start()
        }
    }

    fun generateColor(): Int {
        val randomGenerator = Random(Date().time)
        val red: Int = randomGenerator.nextInt(256)
        val green: Int = randomGenerator.nextInt(256)
        val blue: Int = randomGenerator.nextInt(256)

        return Color.rgb(red, green, blue)
    }
}

