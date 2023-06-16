package com.football_score.core.di

import com.football_score.data.remote.FootballAPIService
import com.football_score.data.repository.MatchRepositoryImpl
import com.football_score.domain.repository.MatchRepository
import com.football_score.domain.use_case.UseCase
import com.football_score.domain.use_case.match.GetAllHotMatchUseCase
import com.football_score.domain.use_case.match.GetAllLiveMatchUseCase
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
    fun provideUseCases(repository: MatchRepository): UseCase =
        UseCase(
            getAllLiveMatch = GetAllLiveMatchUseCase(repository),
            getAllHotMatch = GetAllHotMatchUseCase(repository)
        )
}