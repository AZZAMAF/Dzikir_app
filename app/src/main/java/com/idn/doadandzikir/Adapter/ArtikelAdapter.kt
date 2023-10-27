package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.Utills.OnItemCallBack
import com.idn.doadandzikir.databinding.ItemArtikelBinding

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArticleMyViewHolder>() {

    private var listArtikel = ArrayList<Artikel>()
    private var onItemCallBack: OnItemCallBack? = null

    fun setData(list: List<Artikel>) {
        listArtikel.clear()
        listArtikel.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallBack) {
        this.onItemCallBack = onItemCallback
    }

    inner class ArticleMyViewHolder(val view: ItemArtikelBinding) :
        RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleMyViewHolder(
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun getItemCount() = listArtikel.size

    override fun onBindViewHolder(holder: ArticleMyViewHolder, position: Int) {
        val data = listArtikel[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            onItemCallBack?.onItemCliked(data)
        }
    }

}