package com.example.jetpackcomposenote.domain.usecases

import com.example.jetpackcomposenote.domain.exception.InvalidNoteException
import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("title is blank")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("content is blank")
        }
        repository.insertNote(note)
    }
}