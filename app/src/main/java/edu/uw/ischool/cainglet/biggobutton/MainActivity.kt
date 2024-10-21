package edu.uw.ischool.cainglet.biggobutton
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import kotlin.random.Random
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0
    private lateinit var primaryButton: Button
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        primaryButton = findViewById(R.id.btn_primary)
        primaryButton.setOnClickListener {
            val randomTextColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            val randomBackgroundColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))

            primaryButton.setTextColor(randomTextColor)
            primaryButton.setBackgroundColor(randomBackgroundColor)
            counter++

            ObjectAnimator.ofFloat(primaryButton, "rotation", 0f, 720f).apply {
                duration = 1000 // Duration of rotation
                start()
            }

            if (counter == 1) {
                primaryButton.text = "You have pushed me $counter time!"
            } else if (counter > 1) {
                primaryButton.text = "You have pushed me $counter times!"
            }
        }
    }
}