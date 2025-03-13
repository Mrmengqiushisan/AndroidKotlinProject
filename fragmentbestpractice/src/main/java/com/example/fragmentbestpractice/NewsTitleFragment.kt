package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsTitleFragment:Fragment() {

    private var isTwoPane=false


    inner class NewsAdapter(val newsList: List<News>):RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

        inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
            val newsTitle:TextView=view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.new_items,parent,false)
            val holder=ViewHolder(view)
            holder.itemView.setOnClickListener{
                val news=newsList[holder.adapterPosition]
                if(isTwoPane){
                    //说明是双页的
                    val fragment=requireActivity().supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refresh(news.title,news.content)
                }else{
                    //单页面
                    NewsContentActivity.actionStart(parent.context,news.title,news.content)
                }
            }
            return  holder
        }

        override fun getItemCount()=newsList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news:News=newsList[position]
            holder.newsTitle.text=news.title
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag,container,false)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane=activity?.findViewById<View>(R.id.newsContentLayout)!=null
        val layoutManager=LinearLayoutManager(activity)
        val newsTitleRecyclerView=requireActivity().supportFragmentManager.findFragmentById(R.id.newsTitleRecyclerView) as RecyclerView
        newsTitleRecyclerView.layoutManager=layoutManager
        val adapter=NewsAdapter(getNews())
        newsTitleRecyclerView.adapter=adapter
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isTwoPane=requireView().findViewById<View>(R.id.newsContentFrag)!=null
        val layoutManager=LinearLayoutManager(activity)
        val newsTitleRecyclerView=requireView().findViewById<RecyclerView>(R.id.newsTitleRecyclerView)
        newsTitleRecyclerView.layoutManager=layoutManager
        val adapter=NewsAdapter(getNews())
        newsTitleRecyclerView.adapter=adapter
    }

    private fun getNews():List<News>{
        val newsList=ArrayList<News>()
        for(i in 1..50){
            val news=News("This is news Title $i",getRandomLengthString("This is news Content $i"))
            newsList.add(news)
        }
        return  newsList
    }

    private fun getRandomLengthString(str:String):String{
        val n=(1..20).random()
        val builder=StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }
}