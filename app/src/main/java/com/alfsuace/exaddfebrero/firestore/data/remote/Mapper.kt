package com.alfsuace.exaddfebrero.firestore.data.remote

import com.alfsuace.exaddfebrero.domain.Album
import com.alfsuace.exaddfebrero.domain.Mushroom
import com.alfsuace.exaddfebrero.domain.Sticker

fun Mushroom.toEntity():MushroomEntity{
    return MushroomEntity(
        this.id,
        this.name,
        this.family,
        this.description
    )
}

fun MushroomEntity.toModel():Mushroom{
    return Mushroom(
        this.id,
        this.name,
        this.family,
        this.description
    )
}

fun Sticker.toEntity(mushroomId: String):StickerEntity{
    return StickerEntity(
        this.id,
        mushroomId,
        this.photo,
        this.latitude,
        this.longitude,
        this.dateTime
    )
}

fun StickerEntity.toModel(mushroom: Mushroom):Sticker{
    return Sticker(
        this.id,
        mushroom,
        this.photo,
        this.latitude,
        this.longitude,
        this.dateTime
    )
}

fun Album.toEntity(shroomsId: List<String>, stickersId: List<String>):AlbumEntity{
    return AlbumEntity(
        this.id,
        this.name,
        shroomsId,
        stickersId
    )
}

fun AlbumEntity.toModel(shrooms: List<Mushroom>, stickers: List<Sticker>):Album{
    return Album(
        this.id,
        this.name,
        shrooms,
        stickers
    )
}