package com.yara.thenewsapp.adapters

import android.icu.text.CaseMap.Title
import android.location.GnssAntennaInfo.Listener
import android.media.AudioDescriptor
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yara.thenewsapp.R
import com.yara.thenewsapp.models.Article
import com.yara.thenewsapp.models.Source

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleVewHolder>(){
    inner class ArticleVewHolder(iteamView:View):RecyclerView.ViewHolder(iteamView)
    lateinit var articleImage: ImageView
    lateinit var articalSource: TextView
    lateinit var articalTitle: TextView
    lateinit var articaDescriptor: TextView
    lateinit var articalTime: TextView

    private val differCallback = object:DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    val differ=AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVewHolder {
        return ArticleVewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news ,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return  differ.currentList.size
    }
    private var onItemClickListener: ((Article) -> Unit?)? =null
    override fun onBindViewHolder(holder: ArticleVewHolder, position: Int) {
        val article =differ.currentList[position]
        articleImage=holder.itemView.findViewById((R.id.articleImage))
        articleImage=holder.itemView.findViewById(R.id.articleImage)
        articalSource=holder.itemView.findViewById(R.id.articleSource)
        articalTitle=holder.itemView.findViewById(R.id.articleTitle)
        articaDescriptor=holder.itemView.findViewById(R.id.articleDescription)
        articalTime =holder.itemView.findViewById(R.id.articleDateTime)

        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(articleImage)
            articalSource.text=article.source?.name
            articalTitle.text=article.title
            articaDescriptor.text=article.description
            articalTime.text=article.publishedAt
            setOnClickListener{
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }
    fun setOnItemClickListener(listener: (Article)->Unit){
        onItemClickListener=listener
    }


}