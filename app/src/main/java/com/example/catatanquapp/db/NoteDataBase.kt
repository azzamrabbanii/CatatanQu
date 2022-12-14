package com.example.catatanquapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao() : NoteDAO

    companion object{
        @Volatile private var instance: NoteDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            NoteDataBase::class.java,
            "note12345.db"
        ).build()

    }

}