package com.example.hw_3_m5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.hw_03_m5.Character
import com.example.hw_03_m5.CharacterAdapter
import com.example.hw_03_m5.CharacterPresenter
import com.example.hw_03_m5.CharactersDataSourceFactory
import com.example.hw_03_m5.CharactersView
import com.example.hw_3_m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CharactersView {
    private lateinit var binding: ActivityMainBinding
    private val presenter by lazy {
        CharacterPresenter(
            CharactersDataSourceFactory()
        )
    }
    private var characterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        presenter.getCharacters()
    }

    override fun getCharacters(data: LiveData<PagedList<Character>>) {
        data.observe(this) {
            binding.rvCharacter.apply {  adapter = characterAdapter}
        }
    }
}