package com.football_score.viewmodel.state

import com.football_score.data.remote.model.LiveMatchResponse

sealed class MatchState {
    object Empty: MatchState()
    object Loading: MatchState()
    class Success(val data: LiveMatchResponse): MatchState()
    class Error(val message: String): MatchState()
}
