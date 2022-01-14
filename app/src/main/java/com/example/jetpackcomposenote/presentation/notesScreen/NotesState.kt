package com.example.jetpackcomposenote.presentation.notesScreen

import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.util.NoteOrder
import com.example.jetpackcomposenote.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
