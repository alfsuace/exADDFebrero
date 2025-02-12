package com.alfsuace.exaddfebrero.room.data.local

import com.alfsuace.exaddfebrero.domain.Album

class AlbumLocalDbDataSource(private val albumDao: AlbumDao) {

    fun getAllAlbums(): List<Album>{
        return albumDao.getAlbums().map {
            it.toModel()
        }
    }

    fun getAlbum(albumId: String): Album? {
        return albumDao.getAlbumById(albumId)?.toModel()
    }

    fun insertAllAlbums(albums: List<Album>){
        albumDao.insertAllAlbums(*albums.map{it.toEntity()}.toTypedArray())
    }

    fun inserAlbum(album: Album){
        albumDao.insertAlbum(album.toEntity())
    }

    fun deleteAlbum(album: Album){
        albumDao.deleteAlbum(album.toEntity())
    }
}