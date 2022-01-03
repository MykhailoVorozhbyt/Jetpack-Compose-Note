package com.example.jetpackcomposenote.di

import android.app.Application
import androidx.room.Room
import com.example.jetpackcomposenote.feature_note.data.data_source.NoteDatabase
import com.example.jetpackcomposenote.feature_note.data.data_source.NoteDatabase.Companion.DATABASE_NAME
import com.example.jetpackcomposenote.feature_note.data.repository_impl.NoteRepositoryImpl
import com.example.jetpackcomposenote.feature_note.domain.repository.NoteRepository
import com.example.jetpackcomposenote.feature_note.domain.use_cases.DeleteNoteUseCase
import com.example.jetpackcomposenote.feature_note.domain.use_cases.GetNotesUseCase
import com.example.jetpackcomposenote.feature_note.domain.use_cases.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase =
        Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase): NoteRepository =
        NoteRepositoryImpl(db.noteDaoServices)

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCase =
        NoteUseCase(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
        )
}