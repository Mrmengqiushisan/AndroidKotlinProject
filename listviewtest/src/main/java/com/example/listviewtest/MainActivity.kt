package com.example.listviewtest

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop

class MainActivity : AppCompatActivity() {

    private val data = listOf(
        "Apple",
        "Banana",
        "Orange",
        "Watermelon",
        "Pear",
        "Grape",
        "Pineapple",
        "Strawberry",
        "Cherry",
        "Mango",
        "Apple",
        "Banana",
        "Orange",
        "Watermelon",
        "Pear",
        "Grape",
        "Pineapple",
        "Strawberry",
        "Cherry",
        "Mango"
    )

    private lateinit var listView: ListView

    private val fruitList = ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFruits()

        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)

        listView = findViewById(R.id.listView)

        listView.adapter = adapter

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (supportActionBar != null) {
            val params = listView.layoutParams as ViewGroup.MarginLayoutParams
            params.topMargin = supportActionBar?.height ?: 0
            listView.layoutParams = params
        }
    }

    fun initFruits() {
        fruitList.add(Fruit("Apple", R.drawable.apple_pic))
        fruitList.add(Fruit("Banana", R.drawable.banana_pic))
        fruitList.add(Fruit("Orange", R.drawable.orange_pic))
        fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
        fruitList.add(Fruit("Pear", R.drawable.pear_pic))
        fruitList.add(Fruit("Grape", R.drawable.grape_pic))
        fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
        fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
        fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
        fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        fruitList.add(Fruit("Apple", R.drawable.apple_pic))
        fruitList.add(Fruit("Banana", R.drawable.banana_pic))
        fruitList.add(Fruit("Orange", R.drawable.orange_pic))
        fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
        fruitList.add(Fruit("Pear", R.drawable.pear_pic))
        fruitList.add(Fruit("Grape", R.drawable.grape_pic))
        fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
        fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
        fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
        fruitList.add(Fruit("Mango", R.drawable.mango_pic))
    }

}