package com.example.wechatpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val ARG_PARAM1 = "param1"


class BlankFragment : Fragment() {

    private lateinit var rootView: View

    private var param1:String?="DEFAULT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1=it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_blank, container, false)
        initView()
        return rootView
    }

    private fun initView() {
        val textView=rootView.findViewById<TextView>(R.id.textView)
        textView.text=param1
    }

    companion object{
        fun newInstance(param:String):Fragment{
            val fragment=BlankFragment()
            val bundle=Bundle()
            bundle.putString(ARG_PARAM1,param)
            fragment.arguments=bundle
            return fragment
        }
    }

}