package com.alfsuace.exaddfebrero.room.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDao {

    @Query("SELECT * FROM $ALBUMS")
    fun getAlbums():List<AlbumEntity>

    @Query("SELECT * FROM albums WHERE id = :albumId LIMIT 1")
    fun getAlbumById(albumId: String): AlbumEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAlbums(vararg album: AlbumEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbum(album: AlbumEntity)

    @Delete
    fun deleteAlbum(album: AlbumEntity)
}