package com.alfsuace.exaddfebrero.firestore.data.remote

import com.alfsuace.exaddfebrero.domain.Album
import com.alfsuace.exaddfebrero.domain.Mushroom
import com.alfsuace.exaddfebrero.domain.Sticker
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AlbumRemoteDataSource(private val firestore: FirebaseFirestore) {

    suspend fun getAlbums(): List<Album> {
        val snapshot = firestore.collection("Album").get().await()

        val albumEntityList = snapshot.documents.mapNotNull {
            it.toObject(AlbumEntity::class.java)
        }

        return albumEntityList.map { albumEntity ->
            val mushrooms = albumEntity.shroomAvailable.mapNotNull { getMushroom(it) }
            val stickers = albumEntity.stickers.mapNotNull { getSticker(it) }

            albumEntity.toModel(mushrooms, stickers)
        }
    }

    suspend fun getAlbumById(id: String): Album? {
        val snapshot = firestore.collection("Album").document(id).get().await()
        val albumEntity = snapshot.toObject(AlbumEntity::class.java)

        return albumEntity?.let {
            val mushrooms = it.shroomAvailable.mapNotNull { mushroomId -> getMushroom(mushroomId) }
            val stickers = it.stickers.mapNotNull { stickerId -> getSticker(stickerId) }
            it.toModel(mushrooms, stickers)
        }
    }

    suspend fun saveAllAlbums(albums: List<Album>) {
        val albumCollection = firestore.collection("Album")

        albums.forEach { album ->
            val mushroomIds = album.shroomAvailable.map { it.id }
            val stickerIds = album.stickers.map { it.id }
            albumCollection.document(album.id).set(album.toEntity(stickerIds, mushroomIds)).await()
        }
    }


    suspend fun saveAlbum(album: Album) {
        val stickerIds = album.stickers.map { it.id }
        val mushroomIds = album.shroomAvailable.map { it.id }
        val albumEntity = album.toEntity(mushroomIds, stickerIds)
        firestore.collection("Album").document(album.id).set(albumEntity).await()
    }

    suspend fun deleteAlbum(album: Album) {
        firestore.collection("Album").document(album.id).delete().await()
    }

    suspend fun getSticker(id: String): Sticker? {
        val snapshot = firestore.collection("Sticker").document(id).get().await()
        val stickerEntity = snapshot.toObject(StickerEntity::class.java)

        return stickerEntity?.let { entity ->
            getMushroom(entity.shroom)?.let { entity.toModel(it) }
        }
    }

    suspend fun getMushroom(id: String): Mushroom? {
        val snapshot = firestore.collection("Mushroom").document(id).get().await()
        return snapshot.toObject(MushroomEntity::class.java)?.toModel()
    }

    suspend fun saveStickers(stickers: List<Sticker>) {
        val stickerCollection = firestore.collection("Sticker")

        stickers.forEach { sticker ->
            stickerCollection.document(sticker.id).set(sticker.toEntity(sticker.shroom.id)).await()
        }
    }

    suspend fun saveMushrooms(mushrooms: List<Mushroom>) {
        val mushroomCollection = firestore.collection("Mushroom")

        mushrooms.forEach { mushroom ->
            mushroomCollection.document(mushroom.id).set(mushroom.toEntity()).await()
        }
    }

}
