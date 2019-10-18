package page.marcelo.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val calculateButton = findViewById<Button>(R.id.calculate_btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener{
            onClick()
        }
    }

    private fun onClick() {
        val weightEditView = findViewById<EditText>(R.id.weight_et)
        val weight = weightEditView.text.toString().toFloat()
        val heightEditView = findViewById<EditText>(R.id.height_et)
        val height = heightEditView.text.toString().toFloat()
        val bmi = calculate(weight, height)
        val result = interpretate(bmi)
        val resultTextView = findViewById<TextView>(R.id.result_tv)
        resultTextView.setText(result)
    }

    private fun calculate(weight: Float, height: Float) = weight / ( height * height)

    private fun interpretate(BMI: Float): String {
        if (BMI < 16) {
            return "Severe thinness"
        } else if (BMI > 16 && BMI < 17) {
            return "Moderate thinness"
        } else if (BMI > 17 && BMI < 18.5) {
            return "Mild thinness"
        } else if (BMI > 18.5 && BMI < 25) {
            return "Normal"
        } else if (BMI > 25 && BMI < 30) {
            return "Overweight"
        } else if (BMI > 30 && BMI < 35) {
            return "Obese Class I"
        } else if (BMI > 35 && BMI < 40) {
            return "Obese Class II"
        } else if (BMI > 40) {
            return "Obese Class III"
        } else {
            return ""
        }
    }
}
