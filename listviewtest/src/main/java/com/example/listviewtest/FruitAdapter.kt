package com.example.listviewtest

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

class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    private val TAG: String = "FruitAdapter"

    inner class ViewHolder(
        val fruitImage: ImageView,
        val fruitName: TextView,
        index:Int,
        editText: EditText
    ){
        val holderEditText:EditText=editText

        var indexedValue:Int=index

        val textWatcher=object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Log.d(TAG, s.toString())
                if(s.toString().isNotEmpty()){
                    dataList[indexedValue] = s.toString()
                    Log.d(TAG, "Current Position is $indexedValue,TextChanged is {${dataList[indexedValue]}}")
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
    }


    private  val dataList: Array<String> = Array<String>(data.size){""}

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            val fruitEdit: EditText = view.findViewById(R.id.fruitEdit)
            viewHolder = ViewHolder(fruitImage, fruitName,position,fruitEdit).apply {
                holderEditText.addTextChangedListener(textWatcher)
            }
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
            viewHolder.holderEditText.removeTextChangedListener(viewHolder.textWatcher)
            viewHolder.indexedValue=position
            viewHolder.holderEditText.addTextChangedListener(viewHolder.textWatcher)
        }

        viewHolder.holderEditText.setText(dataList[viewHolder.indexedValue])

        Log.d(TAG, "EditText is {${viewHolder.holderEditText.text}},Current Position is ${viewHolder.indexedValue}")

        val fruit = getItem(position)

        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }

        return view
    }
}