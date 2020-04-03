package io.mns.dope_background_transition.utils

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.View
import java.util.*
import kotlin.random.Random


fun View.animateColor(from: Int, to: Int, duration: Long) {
    val animation =
        ValueAnimator.ofObject(ArgbEvaluator(), from, to)
    animation.duration = duration
    animation.addUpdateListener {
        setBackgroundColor(it.animatedValue as Int)
    }
    animation.start()
}

fun generateColor(): Int {
    val randomGenerator = Random(Date().time)
    val red: Int = randomGenerator.nextInt(256)
    val green: Int = randomGenerator.nextInt(256)
    val blue: Int = randomGenerator.nextInt(256)

    return Color.rgb(red, green, blue)
}