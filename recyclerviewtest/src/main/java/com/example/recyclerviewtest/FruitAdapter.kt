package com.example.recyclerviewtest

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransitionImpl
import androidx.recyclerview.widget.RecyclerView
import java.util.Objects

class FruitAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    private val TAG: String = "FruitAdapter"

    private val dataList = Array<String>(fruitList.size) { "" }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
        val fruitEdit: EditText = view.findViewById(R.id.fruitEdit)
        var fruitIndex: Int = Int.MIN_VALUE
        val textWatcher = object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) {
                    if (fruitIndex == Int.MIN_VALUE) return
                    dataList[fruitIndex] = s.toString()
                    Log.d(
                        TAG,
                        "Current Position is $fruitIndex,TextChanged is {${dataList[fruitIndex]}}"
                    )
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.fruitEdit.removeTextChangedListener(holder.textWatcher)
        if(holder.fruitIndex!= Int.MIN_VALUE){
            Log.d(TAG,"Current View is Exist Postion is ${holder.fruitIndex}")
        }
        holder.fruitIndex = position
        holder.fruitEdit.addTextChangedListener(holder.textWatcher)

        val fruit = fruitList[position]
        holder.fruitName.text = fruit.name
        holder.fruitImage.setImageResource(fruit.imageId)

        if (dataList[position].isNotEmpty()) {
            Log.d(TAG,"Data Updated Position:$position, Context:{${dataList[position]}}")
            holder.fruitEdit.setText(dataList[position])
        } else {
            holder.fruitEdit.setText(fruit.edit)
        }

    }


}