package com.example.jetpackcomposenote.feature_note.presentation.notes_screen

import com.example.jetpackcomposenote.feature_note.domain.model.Note
import com.example.jetpackcomposenote.feature_note.domain.util.NoteOrder
import com.example.jetpackcomposenote.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
