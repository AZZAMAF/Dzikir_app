package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.DoadanDzikirItem
import com.idn.doadandzikir.R

class DoadanDzikirAdapter : RecyclerView.Adapter<DoadanDzikirAdapter.DzikirViewHolder>  ()  {

    private val listData = ArrayList<DoadanDzikirItem>()

    fun setData(list: List<DoadanDzikirItem>){
        listData.clear()
        listData.addAll(list)
    }




    inner class DzikirViewHolder (view:View): RecyclerView.ViewHolder(view){
        val itemTitle = view.findViewById<TextView>(R.id.tv_desc)
        val itemArabic =view.findViewById<TextView>(R.id.tv_lafaz)
        val itemTranslate=view.findViewById<TextView>(R.id.tv_terjemah)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa,parent,false)
    )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
       holder.apply {
           itemTitle.text = listData[position].title
           itemArabic.text = listData[position].arabic
           itemTranslate.text =listData[position].transalate
       }
    }


}









