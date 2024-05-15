package com.example.hw_03_m5

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

interface CharactersView {

    fun getCharacters(data: LiveData<PagedList<com.example.hw_03_m5.Character>>)
}