package com.example.jetpackcomposenote.feature_note.domain.use_cases

import com.example.jetpackcomposenote.feature_note.domain.model.Note
import com.example.jetpackcomposenote.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note? = repository.getNoteById(id)
}