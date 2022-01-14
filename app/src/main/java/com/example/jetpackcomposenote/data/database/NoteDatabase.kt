package com.example.jetpackcomposenote.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomposenote.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDaoServices: NoteDaoServices

    companion object{
        const val DATABASE_NAME = "notes_db"
    }

}