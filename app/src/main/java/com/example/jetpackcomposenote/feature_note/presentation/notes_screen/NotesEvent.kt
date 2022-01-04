package com.example.jetpackcomposenote.feature_note.presentation.notes_screen

import com.example.jetpackcomposenote.feature_note.domain.model.Note
import com.example.jetpackcomposenote.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSelection: NotesEvent()
}
