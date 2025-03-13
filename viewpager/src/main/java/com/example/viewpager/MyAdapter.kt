package com.example.viewpager

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class MyAdapter(val listView: List<View>) : PagerAdapter() {

    override fun getCount() = listView.size

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(listView[position], 0)
        return listView[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(listView[position])
    }

}