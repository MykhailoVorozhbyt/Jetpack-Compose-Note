package com.example.jetpackcomposenote.presentation.notesScreen

import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSelection: NotesEvent()
}
