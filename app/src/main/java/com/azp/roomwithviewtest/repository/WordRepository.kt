package com.azp.roomwithviewtest.repository

import androidx.lifecycle.LiveData
import com.azp.roomwithviewtest.dao.WordDao
import com.azp.roomwithviewtest.entity.Word

class WordRepository (private val wordDao: WordDao){

    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word:Word) {  //insert(Word("Hello"))
        wordDao.insert(word)
    }
}