package com.example.jetpackcomposenote.data.database

import androidx.room.*
import com.example.jetpackcomposenote.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDaoServices {

    @Query("SELECT * FROM Note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}