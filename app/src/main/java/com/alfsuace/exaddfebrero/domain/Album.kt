package com.alfsuace.exaddfebrero.domain

data class Album(
    val id: String,
    val name: String,
    val shroomAvailable: List<Mushroom>,
    val stickers: List<Sticker>
)
