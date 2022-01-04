package com.example.jetpackcomposenote.feature_note.presentation.action_note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun HintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    hintVisibility: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    Box(
        modifier = modifier
    ){
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                }
        )
        if(hintVisibility){
            Text(text = hint, style = textStyle, color = Color.DarkGray)
        }
    }
}