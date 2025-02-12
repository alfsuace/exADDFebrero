package com.alfsuace.exaddfebrero.firestore.data.remote

import com.google.firebase.firestore.PropertyName

data class MushroomEntity(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("family") @set:PropertyName("family") var family: String = "",
    @get:PropertyName("description") @set:PropertyName("description") var description: String = ""
)