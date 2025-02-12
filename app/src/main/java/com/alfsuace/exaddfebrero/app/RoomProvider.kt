package com.alfsuace.exaddfebrero.app

import android.content.Context
import androidx.room.Room

object RoomProvider {

    fun provideDb(context: Context): ShroomsDataBase {
        return Room.databaseBuilder(
            context,
            ShroomsDataBase::class.java, "ShroomsDb"
        ).build()
    }
}