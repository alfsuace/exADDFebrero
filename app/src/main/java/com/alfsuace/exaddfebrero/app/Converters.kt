package com.alfsuace.exaddfebrero.app

import androidx.room.TypeConverter
import com.alfsuace.exaddfebrero.domain.Mushroom
import com.alfsuace.exaddfebrero.domain.Sticker
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromStickerList(stickers: List<Sticker>): String {
        return Gson().toJson(stickers)
    }

    @TypeConverter
    fun toStickerList(data: String): List<Sticker> {
        return Gson().fromJson(data, Array<Sticker>::class.java).toList()
    }

    @TypeConverter
    fun fromMushroomList(mushrooms: List<Mushroom>): String {
        return Gson().toJson(mushrooms)
    }

    @TypeConverter
    fun toMushroomList(data: String): List<Mushroom> {
        return Gson().fromJson(data, Array<Mushroom>::class.java).toList()
    }
}