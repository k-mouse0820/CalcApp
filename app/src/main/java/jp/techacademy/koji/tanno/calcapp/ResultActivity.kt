package jp.techacademy.koji.tanno.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import jp.techacademy.koji.tanno.calcapp.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val value1: Double = intent.getDoubleExtra("VALUE1",0.0)
        val value2:Double = intent.getDoubleExtra("VALUE2",0.0)
        val enzan:String? = intent.getStringExtra("ENZAN")

        binding.resultTextView1.text = "$value1  $enzan $value2 = "

        var result: Double = 0.0

        when(enzan)  {
            "+" -> result = value1 + value2
            "-" -> result = value1 - value2
            "*" -> result = value1 * value2
            "/" -> result = value1 / value2
        }

        binding.resultTextView2.text = result.toString()

    }
}