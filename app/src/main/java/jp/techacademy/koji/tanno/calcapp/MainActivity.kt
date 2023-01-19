package jp.techacademy.koji.tanno.calcapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import jp.techacademy.koji.tanno.calcapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcButtonPlus.setOnClickListener(this)
        binding.calcButtonMinus.setOnClickListener(this)
        binding.calcButtonMultiply.setOnClickListener(this)
        binding.calcButtonDivide.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (binding.editText1.text.toString().isBlank() || binding.editText2.text.toString().isBlank()) {
            Snackbar.make(binding.root, "数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("CANCEL") {}.show()
        } else {
            var enzan: String = ""
            when (v.id) {
                R.id.calcButtonPlus -> enzan = "+"
                R.id.calcButtonMinus -> enzan = "-"
                R.id.calcButtonMultiply -> enzan = "*"
                R.id.calcButtonDivide -> enzan = "/"
            }
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("VALUE1", binding.editText1.text.toString().toDouble())
            intent.putExtra("VALUE2", binding.editText2.text.toString().toDouble())
            intent.putExtra("ENZAN", enzan)
            startActivity(intent)
        }

    }
}

        /*
    binding.calcButtonPlus.setOnClickListener {
        if (binding.editText1.text.toString().isBlank() || binding.editText2.text.toString().isBlank()) {
            Snackbar.make(binding.root, "数字を入力してください",Snackbar.LENGTH_INDEFINITE)
                .setAction("CANCEL"){}.show()
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("VALUE1", binding.editText1.text.toString().toDouble())
            intent.putExtra("VALUE2", binding.editText2.text.toString().toDouble())
            intent.putExtra("ENZAN", "+")
            startActivity(intent)
        }
    }
    binding.calcButtonMinus.setOnClickListener{
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("VALUE1",binding.editText1.text.toString().toDouble())
        intent.putExtra("VALUE2",binding.editText2.text.toString().toDouble())
        intent.putExtra("ENZAN","-")
        startActivity(intent)
    }
    binding.calcButtonMultiply.setOnClickListener{
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("VALUE1",binding.editText1.text.toString().toDouble())
        intent.putExtra("VALUE2",binding.editText2.text.toString().toDouble())
        intent.putExtra("ENZAN","*")
        startActivity(intent)
    }
    binding.calcButtonDivide.setOnClickListener{
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("VALUE1",binding.editText1.text.toString().toDouble())
        intent.putExtra("VALUE2",binding.editText2.text.toString().toDouble())
        intent.putExtra("ENZAN","/")
        startActivity(intent)
    }
*/
