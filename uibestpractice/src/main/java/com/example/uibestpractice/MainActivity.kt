package com.example.uibestpractice

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ResourceCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG: String = "MainActivity"

    private lateinit var mainView: LinearLayout

    private val msgList = ArrayList<Msg>()

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MsgAdapter

    private lateinit var send: Button

    private lateinit var inputText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mainView = findViewById(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initMsg()

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager

        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter

        send = findViewById(R.id.send)
        send.setOnClickListener(this)

        inputText = findViewById(R.id.inputText)
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (supportActionBar != null) {
            val params = mainView.layoutParams as ViewGroup.MarginLayoutParams
            params.topMargin = supportActionBar?.height ?: 0
            mainView.layoutParams = params
        }

    }

    private fun initMsg() {
        var msg1 = Msg("Hello guy ", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        msg1 = Msg("Hello,Who is that ", Msg.TYPE_SEND)
        msgList.add(msg1)
        msg1 = Msg("This is Tom,Nice talking to you ", Msg.TYPE_RECEIVED)
        msgList.add(msg1)

    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SEND)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size - 1)
                    recyclerView.scrollToPosition(msgList.size - 1)
                    inputText.setText("")
                }
            }
        }
    }
}