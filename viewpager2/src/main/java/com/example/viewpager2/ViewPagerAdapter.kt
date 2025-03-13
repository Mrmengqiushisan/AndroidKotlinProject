package com.example.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(val viewList: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPageHolder>() {

    inner class ViewPageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.tvTitle)
        val container = view.findViewById<RelativeLayout>(R.id.container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        return ViewPageHolder(view)
    }

    override fun getItemCount() = viewList.size

    override fun onBindViewHolder(holder: ViewPageHolder, position: Int) {
        val value=viewList[position]
        holder.textView.text=value
    }


}