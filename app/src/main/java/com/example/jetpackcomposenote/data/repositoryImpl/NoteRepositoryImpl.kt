package com.example.jetpackcomposenote.data.repositoryImpl

import com.example.jetpackcomposenote.data.database.NoteDaoServices
import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDaoServices
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) = dao.insertNote(note)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)
}