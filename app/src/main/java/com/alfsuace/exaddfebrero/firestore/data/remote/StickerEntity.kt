package com.alfsuace.exaddfebrero.firestore.data.remote

import com.google.firebase.firestore.PropertyName

data class StickerEntity(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("shroom") @set:PropertyName("shroom") var shroom: String = "",
    @get:PropertyName("photo") @set:PropertyName("photo") var photo: String = "",
    @get:PropertyName("latitude") @set:PropertyName("latitude") var latitude: String = "",
    @get:PropertyName("longitude") @set:PropertyName("longitude") var longitude: String = "",
    @get:PropertyName("date_time") @set:PropertyName("date_time") var dateTime: String = ""
)