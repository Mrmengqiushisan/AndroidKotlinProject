package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsContentFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_content_frag,container,false)
    }


    fun refresh(title:String,content:String){
        val contentLayout=requireView().findViewById<LinearLayout>(R.id.contentLayout)
        contentLayout.visibility=View.VISIBLE
        val newsTitle=requireView().findViewById<TextView>(R.id.newsTitle)
        newsTitle.text=title
        val newsContent:TextView=requireView().findViewById(R.id.newsContent)
        newsContent.text=content
    }
}