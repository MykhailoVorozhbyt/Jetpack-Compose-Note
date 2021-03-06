package com.example.jetpackcomposenote.presentation.actionNote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposenote.domain.exception.InvalidNoteException
import com.example.jetpackcomposenote.domain.model.Note
import com.example.jetpackcomposenote.domain.usecases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteActionViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteTitle = mutableStateOf(
        NoteFieldState(
            hint = "Enter title"
        )
    )
    val noteTitle: State<NoteFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(
        NoteFieldState(
            hint = "Enter some content"
        )
    )
    val noteContent: State<NoteFieldState> = _noteContent

    private val _noteColor = mutableStateOf(Note.noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if(noteId != -1){
                viewModelScope.launch {
                    noteUseCases.getNoteUseCase(noteId)?.also { note ->
                        currentNoteId = note.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteContent.value = noteContent.value.copy(
                            text = note.content,
                            isHintVisible = false
                        )
                        _noteColor.value = note.color
                    }
                }
            }
        }
    }

    fun onEvent(event: NoteActionEvent) {
        when (event) {
            is NoteActionEvent.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }
            is NoteActionEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is NoteActionEvent.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }
            is NoteActionEvent.ChangeContentFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteContent.value.text.isBlank()
                )
            }
            is NoteActionEvent.ChangeColor -> {
                _noteColor.value = event.color
            }
            is NoteActionEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNoteUseCase(
                            Note(
                                id = currentNoteId,
                                content = noteContent.value.text,
                                title = noteTitle.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar("${e.message}")
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
        object SaveNote : UiEvent()
    }
}