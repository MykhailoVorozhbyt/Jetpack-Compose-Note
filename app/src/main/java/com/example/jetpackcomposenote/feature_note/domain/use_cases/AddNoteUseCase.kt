package com.example.jetpackcomposenote.feature_note.domain.use_cases

import com.example.jetpackcomposenote.feature_note.domain.exception.InvalidNoteException
import com.example.jetpackcomposenote.feature_note.domain.model.Note
import com.example.jetpackcomposenote.feature_note.domain.repository.NoteRepository

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