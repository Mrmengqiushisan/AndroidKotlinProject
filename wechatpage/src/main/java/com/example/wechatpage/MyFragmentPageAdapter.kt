package com.example.wechatpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentPageAdapter(
    val fragmentList: List<Fragment>,
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount()=fragmentList.size


    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}