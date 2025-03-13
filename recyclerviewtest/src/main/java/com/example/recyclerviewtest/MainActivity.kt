package com.example.recyclerviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val TAG="MainActivity"

    private lateinit var recyclerView:RecyclerView

    private val fruitList=ArrayList<Fruit>()

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

        val layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=layoutManager
        val adapter=FruitAdapter(fruitList)
        recyclerView.adapter=adapter
    }

    fun initFruits() {
        fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
        fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
        fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
        fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon_pic))
        fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
        fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
        fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
        fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry_pic))
        fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
        fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
        fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
        fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
        fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
        fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon_pic))
        fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
        fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
        fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
        fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry_pic))
        fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
        fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
    }

    fun getRandomLengthString(str:String):String{
        val n=(1..20).random()
        val builder=StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }
}