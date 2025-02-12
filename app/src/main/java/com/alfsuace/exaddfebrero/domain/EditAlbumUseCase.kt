package com.alfsuace.exaddfebrero.domain

class EditAlbumUseCase(private val albumRepository: AlbumRepository) {

    suspend operator fun invoke(album: Album, sticker: Sticker){
        val updatedStickers = album.stickers.filter { it.id != sticker.id }
        val updatedAlbum = album.copy(stickers = updatedStickers)
        albumRepository.saveAlbum(updatedAlbum)
    }
}