package com.alfsuace.exaddfebrero

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alfsuace.exaddfebrero.app.RoomProvider
import com.alfsuace.exaddfebrero.domain.Album
import com.alfsuace.exaddfebrero.domain.EditAlbumUseCase
import com.alfsuace.exaddfebrero.domain.Mushroom
import com.alfsuace.exaddfebrero.domain.Sticker
import com.alfsuace.exaddfebrero.room.data.AlbumDataRepository
import com.alfsuace.exaddfebrero.room.data.local.AlbumLocalDbDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executeRoom()
    }

    private fun executeRoom() {
        val mockMushrooms = listOf(
            Mushroom(id = "1", name = "Boletus edulis", family = "Boletaceae", description = "Seta comestible muy apreciada."),
            Mushroom(id = "2", name = "Amanita muscaria", family = "Amanitaceae", description = "Tóxica, de color rojo con puntos blancos."),
            Mushroom(id = "3", name = "Agaricus campestris", family = "Agaricaceae", description = "Conocida como champiñón silvestre."),
            Mushroom(id = "4", name = "Cantharellus cibarius", family = "Cantharellaceae", description = "También conocida como rebozuelo.")
        )
        val mockMushrooms2 = listOf(
            Mushroom(id = "1", name = "Boletus edulis", family = "Boletaceae", description = "Seta comestible muy apreciada."),
            Mushroom(id = "2", name = "Amanita muscaria", family = "Amanitaceae", description = "Tóxica, de color rojo con puntos blancos.")
        )
        val mockStickers = listOf(
            Sticker(id = "101",mockMushrooms[0] ,photo = "https://example.com/photo1.jpg", latitude = "40.4168", longitude = "-3.7038", dateTime = "2025-02-12 14:30"),
            Sticker(id = "102", mockMushrooms[1], photo = "https://example.com/photo2.jpg", latitude = "41.4036", longitude = "2.1744", dateTime = "2025-02-11 10:15"),
            Sticker(id = "103", mockMushrooms[2], photo = "https://example.com/photo3.jpg", latitude = "39.4699", longitude = "-0.3763", dateTime = "2025-02-10 08:45")
        )
        val mockAlbums = listOf(
            Album(id = "A1","2 setas", mockMushrooms,stickers = listOf(mockStickers[0], mockStickers[1])),
            Album(id = "A2","1 seta" ,mockMushrooms2,stickers = listOf(mockStickers[2]))
        )


        val db = RoomProvider.provideDb(this)
        val repo = AlbumDataRepository(AlbumLocalDbDataSource(db.albumDao()))
        val editUseCase = EditAlbumUseCase(repo)

        val albumCreated= Album(
            id = "103",
            "creado",
            mockMushrooms2,
            stickers = listOf(mockStickers[1], mockStickers[2])
        )

        GlobalScope.launch (Dispatchers.IO){
            repo.saveAllAlbums(mockAlbums)
            Log.d("@dev", repo.getAlbums().toString())
            repo.saveAlbum(albumCreated)
            Log.d("@dev", repo.getAlbums().toString())
            repo.deleteAlbum(albumCreated)
            Log.d("@dev", repo.getAlbums().toString())
            //ELIMINAR CROMO
            repo.saveAlbum(albumCreated)
            val album = repo.getAlbumById(albumCreated.id)
            Log.d("@dev", album.toString())
            album?.let {
                editUseCase.invoke(album, mockStickers[1])
            }
            val albumEdited = repo.getAlbumById(albumCreated.id)
            Log.d("@dev", albumEdited.toString())


        }
    }
}