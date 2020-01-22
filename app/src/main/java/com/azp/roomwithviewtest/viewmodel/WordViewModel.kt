package com.azp.roomwithviewtest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.azp.roomwithviewtest.database.WordRoomDatabase
import com.azp.roomwithviewtest.entity.Word
import com.azp.roomwithviewtest.repository.WordRepository
import kotlinx.coroutines.launch

//Class extends AndroidViewModel and requires application as a parameter
class WordViewModel(application: Application) : AndroidViewModel(application) {

    //The ViewModel maintains a reference to the repository to get data
    private val repository: WordRepository
    //LiveData gives us updated words when they change
    val allWords: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase
            .getDatabase(application,viewModelScope)
            .wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }

    //to handle the background task
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}