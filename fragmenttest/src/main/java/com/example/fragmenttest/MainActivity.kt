package com.example.fragmenttest

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

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

        val fragment=supportFragmentManager.findFragmentById(R.id.leftFrag) as LeftFragment

        fragment.requireView().findViewById<Button>(R.id.Send).setOnClickListener{
            replaceFragment(AnotherRightFragment())
        }

        val rightFragment=RightFragment()
        rightFragment.setFragmentListener(object :IFragmentListener{
            override fun sendMsgToActivity(msg: String) {

            }

            override fun receiveMsgFromActivity(msg: String): String {
                return "this is main Activity"
            }

        })
        replaceFragment(rightFragment)

    }


    fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}