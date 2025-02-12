package com.alfsuace.exaddfebrero.firestore.data

import com.alfsuace.exaddfebrero.domain.Album
import com.alfsuace.exaddfebrero.domain.AlbumRepository
import com.alfsuace.exaddfebrero.firestore.data.remote.AlbumRemoteDataSource

class AlbumDataRepositoryFirestore(private val albumRemoteDataSource: AlbumRemoteDataSource):AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        return albumRemoteDataSource.getAlbums()
    }

    override suspend fun getAlbumById(id: String): Album? {
        return albumRemoteDataSource.getAlbumById(id)
    }

    override suspend fun saveAllAlbums(albums: List<Album>) {
        albumRemoteDataSource.saveAllAlbums(albums)
    }

    override suspend fun saveAlbum(album: Album) {
        albumRemoteDataSource.saveAlbum(album)
    }

    override suspend fun deleteAlbum(album: Album) {
        albumRemoteDataSource.deleteAlbum(album)
    }
}