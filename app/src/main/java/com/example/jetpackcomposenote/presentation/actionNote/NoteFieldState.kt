package com.example.jetpackcomposenote.presentation.actionNote

data class NoteFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)