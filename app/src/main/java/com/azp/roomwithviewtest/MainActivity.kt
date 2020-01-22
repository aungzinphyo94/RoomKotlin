package com.azp.roomwithviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azp.roomwithviewtest.adapter.WordAdapter
import com.azp.roomwithviewtest.viewmodel.WordViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = WordAdapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_word).apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        wordViewModel.allWords.observe(this,
            Observer { words ->
            words?.let { adapter.setWords(it) }
        })
    }
}
