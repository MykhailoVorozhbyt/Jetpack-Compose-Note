package com.example.jetpackcomposenote.presentation.actionNote

import androidx.compose.ui.focus.FocusState

sealed class NoteActionEvent {
    data class EnteredTitle(val value: String) : NoteActionEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : NoteActionEvent()
    data class EnteredContent(val value: String) : NoteActionEvent()
    data class ChangeContentFocus(val focusState: FocusState) : NoteActionEvent()
    data class ChangeColor(val color: Int) : NoteActionEvent()
    object SaveNote : NoteActionEvent()
}