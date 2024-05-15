package com.example.hw_03_m5

class CharactersResponse(
    val info: Info,
    val results: List<Character>
)

class Info(
    val pages: Int,
    val next: String? = null,
    val prev: String? = null
)

class Character(
    val id: Int,
    val name: String,
    val image: String
)