package com.example.activitylifecycletest

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.appcompat.app.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activitylifecycletest.databinding.ActivityMainBinding
import com.example.activitylifecycletest.ui.theme.AndroidKotlinProjectTheme

class MainActivity : AppCompatActivity(), OnClickListener {

    private val TAG: String = "MainActivity"

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        val drawalbe: GradientDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 10.0F
            setStroke(2, Color.BLACK)
            setColor(Color.WHITE)
        }
        imageView.background = drawalbe

        val fitStartBtn: Button = findViewById(R.id.fitStartPoetry)
        fitStartBtn.setOnClickListener(this)

        val btnIds = listOf(
            R.id.fitStartPoetry,
            R.id.fitCenter,
            R.id.fitEnd,
            R.id.center,
            R.id.fitXY,
            R.id.centerCrop,
            R.id.centerInside,
            R.id.matrix
        )

        for (btnId in btnIds) {
            val button: Button = findViewById(btnId)
            button.setOnClickListener(this)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }


    override fun onClick(v: View?) {
        imageView.setImageResource(R.drawable.img2)
        when (v?.id) {
            R.id.fitStartPoetry -> {
                imageView.scaleType = ImageView.ScaleType.FIT_START
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something Important")
                    setCancelable(false)
                    setPositiveButton("Ok"){dialog,which->

                    }
                    setNegativeButton("Cancel"){dialog,which->

                    }
                    show()
                }
            }

            R.id.fitCenter -> {
                imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            }

            R.id.fitEnd -> {
                imageView.scaleType = ImageView.ScaleType.FIT_END
            }

            R.id.fitXY -> {
                imageView.scaleType = ImageView.ScaleType.FIT_XY
            }

            R.id.center -> {
                imageView.scaleType = ImageView.ScaleType.CENTER
            }

            R.id.centerCrop -> {
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            }

            R.id.centerInside -> {
                imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }

            R.id.matrix -> {
                imageView.scaleType = ImageView.ScaleType.MATRIX
            }

        }
    }


}
