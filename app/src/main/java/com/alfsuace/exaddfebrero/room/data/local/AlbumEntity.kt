package com.alfsuace.exaddfebrero.room.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alfsuace.exaddfebrero.domain.Mushroom
import com.alfsuace.exaddfebrero.domain.Sticker

const val ALBUMS ="albums"

@Entity(tableName = ALBUMS)
data class AlbumEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name="shroom_available") val shroomAvailable: List<Mushroom>,
    @ColumnInfo(name = "mushrooms")val stickers: List<Sticker>
)