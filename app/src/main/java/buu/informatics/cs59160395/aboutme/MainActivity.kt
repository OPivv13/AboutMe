package buu.informatics.cs59160395.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.view.*

import buu.informatics.cs59160395.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply{
            doneButton.setOnClickListener {
                addNickname(it)
            }
            nicknameText.setOnClickListener {
                updateNickname(it)
            }
        }
    }

    private fun updateNickname (view: View){
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE

            doneButton.visibility = View.VISIBLE

            nicknameEdit.requestFocus()
            // show the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }

    }

    private fun addNickname(view: View){
        binding.apply {
            binding.nicknameText.text = binding.nicknameEdit.text
            binding.nicknameEdit.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
            binding.doneButton.visibility = View.GONE

            // hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}
