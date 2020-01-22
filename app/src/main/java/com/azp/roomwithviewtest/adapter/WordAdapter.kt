package com.azp.roomwithviewtest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azp.roomwithviewtest.R
import com.azp.roomwithviewtest.entity.Word

class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val wordItem: TextView = itemView.findViewById(R.id.txt_word)
}

class WordAdapter(context: Context) : RecyclerView.Adapter<WordViewHolder>(){

    // Cached copy of words
    private var words = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word,parent,false)
        return WordViewHolder(view)
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.wordItem.text = words[position].word
    }
}