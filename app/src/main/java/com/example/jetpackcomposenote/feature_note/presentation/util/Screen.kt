package com.example.jetpackcomposenote.feature_note.presentation.util

sealed class Screen(
    val route: String
){
    object NotesScreen: Screen("note_creen")
    object ActionNoteScreen: Screen("action_note_creen")
}
