package com.example.wechatpage

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewPager2: ViewPager2

    private lateinit var ivChat: ImageView
    private lateinit var ivContact: ImageView
    private lateinit var ivFind: ImageView
    private lateinit var ivMe: ImageView
    private lateinit var ivCurrent: ImageView

    private lateinit var llChat: LinearLayout
    private lateinit var llContact: LinearLayout
    private lateinit var llFind: LinearLayout
    private lateinit var llMe: LinearLayout

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
        initTabView()
    }

    private fun initTabView() {
        ivChat = findViewById(R.id.tab_iv_weixin)
        ivContact = findViewById(R.id.tab_iv_contact)
        ivFind = findViewById(R.id.tab_iv_find)
        ivMe = findViewById(R.id.tab_iv_me)

        llChat = findViewById(R.id.id_tab_weixin)
        llContact = findViewById(R.id.id_tab_contact)
        llFind = findViewById(R.id.id_tab_find)
        llMe = findViewById(R.id.id_tab_me)

        llChat.setOnClickListener(this)
        llContact.setOnClickListener(this)
        llFind.setOnClickListener(this)
        llMe.setOnClickListener(this)

        llChat.isSelected = true

        ivCurrent = ivChat
    }

    private fun initPage() {
        viewPager2 = findViewById(R.id.viewPager)

        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(BlankFragment.newInstance("微信聊天"))
        fragmentList.add(BlankFragment.newInstance("通讯录"))
        fragmentList.add(BlankFragment.newInstance("发现"))
        fragmentList.add(BlankFragment.newInstance("我"))

        val pageAdapter = MyFragmentPageAdapter(fragmentList, supportFragmentManager, lifecycle)
        viewPager2.adapter = pageAdapter
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                changeTab(position)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
        })

    }

    private fun changeTab(position: Int) {
        ivCurrent.isSelected = false
        ivCurrent = when (position) {

            R.id.id_tab_weixin, 0 -> {
                viewPager2.setCurrentItem(0)
                ivChat.isSelected = true
                ivChat
            }

            R.id.id_tab_contact, 1 -> {
                viewPager2.setCurrentItem(1)
                ivContact.isSelected = true
                ivContact
            }

            R.id.id_tab_find, 2 -> {
                viewPager2.setCurrentItem(2)
                ivFind.isSelected = true
                ivFind
            }

            R.id.id_tab_me, 3 -> {
                viewPager2.setCurrentItem(3)
                ivMe.isSelected = true
                ivMe
            }

            else -> {
                ivCurrent
            }
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            changeTab(it.id)
        }
    }
}