package page.marcelo.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        calculate_btn.setOnClickListener{
            onClick()
        }
    }

    private fun onClick() {
        val weight = weight_et.text.toString().toFloat()
        val height = height_et.text.toString().toFloat()
        val bmi = calculate(weight, height)
        val result = interpretate(bmi)
        result_tv.text = result
    }

    private fun calculate(weight: Float, height: Float) = weight / ((height / 100) * (height / 100))

    private fun interpretate(BMI: Float): String {
        val diagnostic = when (BMI) {
            in 0f..16f -> "Severe thinness"
            in 16f..17f -> "Moderate thinness"
            in 17f..18.5f -> "Mild thinness"
            in 18.5f..25f -> "Normal"
            in 25f..30f -> "Overweight"
            in 30f..35f -> "Obese Class I"
            in 35f..40f -> "Obese Class II"
            else -> "Obese Class III"
        }

        return diagnostic
    }
}
