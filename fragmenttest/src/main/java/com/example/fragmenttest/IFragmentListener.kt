package com.example.fragmenttest

interface IFragmentListener {
    fun sendMsgToActivity(msg:String)
    fun receiveMsgFromActivity(msg: String):String

}