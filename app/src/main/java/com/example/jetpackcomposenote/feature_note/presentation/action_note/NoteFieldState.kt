package com.example.jetpackcomposenote.feature_note.presentation.action_note

data class NoteFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)