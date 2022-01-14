package com.example.jetpackcomposenote.di

import android.app.Application
import androidx.room.Room
import com.example.jetpackcomposenote.BuildConfig
import com.example.jetpackcomposenote.data.database.NoteDatabase
import com.example.jetpackcomposenote.data.database.NoteDatabase.Companion.DATABASE_NAME
import com.example.jetpackcomposenote.data.repositoryImpl.NoteRepositoryImpl
import com.example.jetpackcomposenote.domain.repository.NoteRepository
import com.example.jetpackcomposenote.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
/*    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit =
        Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient)
            baseUrl(BuildConfig.API_BASE_URL)
        }.build()*/



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
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases =
        NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
}