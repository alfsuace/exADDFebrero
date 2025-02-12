package com.alfsuace.exaddfebrero.room.data.local

import com.alfsuace.exaddfebrero.domain.Album

fun AlbumEntity.toModel():Album{
    return Album(
        this.id,
        this.name,
        this.shroomAvailable,
        this.stickers
    )
}

fun Album.toEntity():AlbumEntity{
    return AlbumEntity(
        this.id,
        this.name,
        this.shroomAvailable,
        this.stickers
    )
}