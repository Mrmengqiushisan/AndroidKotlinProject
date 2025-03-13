package com.example.wechatpage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initPage()
    }

    private fun initPage(){
        viewPager2=findViewById(R.id.viewPager)

        val fragmentList=ArrayList<Fragment>()
        fragmentList.add(BlankFragment.newInstance("微信聊天"))
        fragmentList.add(BlankFragment.newInstance("通讯录"))
        fragmentList.add(BlankFragment.newInstance("发现"))
        fragmentList.add(BlankFragment.newInstance("我"))

        val pageAdapter=MyFragmentPageAdapter(fragmentList,supportFragmentManager,lifecycle)
        viewPager2.adapter=pageAdapter

    }
}