package com.example.animationtest

import android.animation.ValueAnimator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG:String="MainActivity"

    private var flag:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.animal_secondtest)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val relativeLayout: RelativeLayout = findViewById(R.id.main)

        /*val anim: AnimationDrawable = relativeLayout.background as AnimationDrawable
        relativeLayout.setOnClickListener {
            if(flag){
                anim.start()
            }else{
                anim.stop()
            }
            flag=!flag
        }*/

        /*val imageView:ImageView=findViewById(R.id.imageView)

        imageView.setOnClickListener{
            val customAnimation:Animation=AnimationUtils.loadAnimation(this,R.anim.translate)
            imageView.startAnimation(customAnimation)
        }*/

        val valueAnimator:ValueAnimator=ValueAnimator.ofFloat(0f,1f)
        valueAnimator.setDuration(2000)
        valueAnimator.addUpdateListener{animator->
            val value:Float=animator.getAnimatedValue() as Float
            Log.d(TAG,"onAnimatorUpdate: $value")
        }
        valueAnimator.start()
    }
}