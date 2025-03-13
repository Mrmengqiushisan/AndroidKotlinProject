package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lf:LayoutInflater=LayoutInflater.from(this)

        val view1=lf.inflate(R.layout.layout1,null)
        val view2=lf.inflate(R.layout.layout2,null)
        val view3=lf.inflate(R.layout.layout3,null)

        val viewList=ArrayList<View>()
        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)

        val myAdapter=MyAdapter(viewList)

        val viewPager = findViewById<ViewPager>(R.id.vp)
        viewPager.adapter=myAdapter



    }
}