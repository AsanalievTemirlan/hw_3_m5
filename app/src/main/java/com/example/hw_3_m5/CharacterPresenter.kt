package com.example.hw_03_m5

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class CharacterPresenter(
    private val dataSourceFactory: CharactersDataSourceFactory

) {
    private var view: CharactersView? = null

    fun getCharacters() {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        val pagedList = LivePagedListBuilder(dataSourceFactory,config).build()
        view?.getCharacters(pagedList)
    }
    fun attachView (view: CharactersView){
        this.view = view
    }

    fun detachView(){
        this.view = null
    }
}