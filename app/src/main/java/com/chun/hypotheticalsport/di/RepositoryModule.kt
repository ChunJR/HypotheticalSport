package com.chun.hypotheticalsport.di

import android.content.Context
import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.usecases.UseCases
import com.chun.hypotheticalsport.domain.usecases.getAllMatches.GetAllMatchesUseCase
import com.chun.hypotheticalsport.domain.usecases.getAllTeams.GetAllTeamsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllMatchesUseCase = GetAllMatchesUseCase(repository = repository),
            getAllTeamsUseCase = GetAllTeamsUseCase(repository = repository),
        )
    }
}
