package com.alfsuace.exaddfebrero.room.data

import com.alfsuace.exaddfebrero.domain.Album
import com.alfsuace.exaddfebrero.domain.AlbumRepository
import com.alfsuace.exaddfebrero.room.data.local.AlbumLocalDbDataSource

class AlbumDataRepository(private val local : AlbumLocalDbDataSource):AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return local.getAllAlbums()
    }

    override suspend fun getAlbumById(id: String): Album? {
        return local.getAlbum(id)
    }

    override suspend fun saveAllAlbums(albums: List<Album>) {
        local.insertAllAlbums(albums)
    }

    override suspend fun saveAlbum(album: Album) {
        local.inserAlbum(album)
    }

    override suspend fun deleteAlbum(album: Album) {
        local.deleteAlbum(album)
    }
}