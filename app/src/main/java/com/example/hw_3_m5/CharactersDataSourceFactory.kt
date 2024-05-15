package com.example.hw_03_m5

import androidx.paging.DataSource
import com.geeks.hw3_5m.CharactersDataSource
import java.lang.Character

class CharactersDataSourceFactory : DataSource.Factory<Int, com.example.hw_03_m5.Character>() {
    override fun create(): DataSource<Int, com.example.hw_03_m5.Character> = CharactersDataSource()
}