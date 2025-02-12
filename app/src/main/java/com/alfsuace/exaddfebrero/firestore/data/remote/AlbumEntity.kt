package com.alfsuace.exaddfebrero.firestore.data.remote

import com.google.firebase.firestore.PropertyName


data class AlbumEntity(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("shroom_available") @set:PropertyName("shroom_available") var shroomAvailable: List<String> = emptyList(),
    @get:PropertyName("stickers") @set:PropertyName("stickers") var stickers: List<String> = emptyList()
)