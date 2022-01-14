package com.example.jetpackcomposenote.domain.usecases

import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note? = repository.getNoteById(id)
}