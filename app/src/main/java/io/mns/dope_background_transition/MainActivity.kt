package io.mns.dope_background_transition

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.mns.dope_background_transition.databinding.ActivityMainBinding
import io.mns.dope_background_transition.utils.animateColor
import io.mns.dope_background_transition.utils.generateColor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var nextColor: Int = Color.WHITE
    private var lastColor: Int = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener {
            nextColor = generateColor()
            binding.root.animateColor(lastColor, nextColor, 600)
            lastColor = nextColor
        }
    }
}
