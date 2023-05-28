package com.football_score.di

import com.football_score.data.remote.FootballAPIService
import com.football_score.data.repository.MatchRepositoryImpl
import com.football_score.data.repository.MatchRepository
import com.football_score.domain.use_cases.UseCases
import com.football_score.domain.use_cases.get_all_live_match.GetAllLiveMatchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMatchRepository(footballAPIService: FootballAPIService): MatchRepository {
        return MatchRepositoryImpl(footballAPIService = footballAPIService)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: MatchRepository): UseCases =
        UseCases(
            getAllLiveMatch = GetAllLiveMatchUseCase(repository)
        )
}