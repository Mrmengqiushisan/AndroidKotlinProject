package com.example.androidkotlinproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidkotlinproject.databinding.SecondLayoutBinding

class SecondActivity : ComponentActivity() {

    private val TAG:String="SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding=SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extraData=intent.getStringExtra("extra_data")
        Log.d(TAG,"extra data is {$extraData}")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button2.setOnClickListener{
            val intent=Intent()
            intent.putExtra("data_return","Hello FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}