package com.example.jetpackcomposenote.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcomposenote.ui.theme.*

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val content: String,
    val title: String,
    val timestamp: Long,
    val color: Int,
) {
    companion object {
        val noteColors = listOf(RedOrange, RedPink, BodyBlue, Violet, LightGreen)
    }
}
