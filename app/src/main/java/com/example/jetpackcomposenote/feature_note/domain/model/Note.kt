package com.example.jetpackcomposenote.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcomposenote.ui.theme.Pink80
import com.example.jetpackcomposenote.ui.theme.Purple40
import com.example.jetpackcomposenote.ui.theme.Purple80
import com.example.jetpackcomposenote.ui.theme.PurpleGrey80

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val content: String,
    val timestamp: Long,
    val color: Int,
) {
    companion object {
        val noteColors = listOf(Purple80, PurpleGrey80, Pink80, Purple40)
    }
}
