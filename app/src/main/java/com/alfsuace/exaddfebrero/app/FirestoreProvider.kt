package com.alfsuace.exaddfebrero.app

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

object FirestoreProvider {
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }
}