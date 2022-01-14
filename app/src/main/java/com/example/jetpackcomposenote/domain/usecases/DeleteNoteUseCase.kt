package com.example.jetpackcomposenote.domain.usecases

import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) =
        repository.deleteNote(note)
}