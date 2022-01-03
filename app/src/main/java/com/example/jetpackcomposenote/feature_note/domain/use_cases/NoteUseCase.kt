package com.example.jetpackcomposenote.feature_note.domain.use_cases

data class NoteUseCase(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)
