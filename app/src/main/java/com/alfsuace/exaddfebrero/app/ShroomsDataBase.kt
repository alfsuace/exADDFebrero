package com.alfsuace.exaddfebrero.app

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alfsuace.exaddfebrero.room.data.local.AlbumDao
import com.alfsuace.exaddfebrero.room.data.local.AlbumEntity

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ShroomsDataBase:RoomDatabase(){

    abstract fun albumDao(): AlbumDao
}