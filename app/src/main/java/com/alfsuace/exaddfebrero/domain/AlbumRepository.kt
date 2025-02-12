package com.alfsuace.exaddfebrero.domain

interface AlbumRepository {

    suspend fun getAlbums():List<Album>
    suspend fun getAlbumById(id: String): Album?
    suspend fun saveAllAlbums(albums : List<Album>)
    suspend fun saveAlbum(album: Album)
    suspend fun deleteAlbum(album: Album)
}