package com.football_score.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football_score.domain.model.response.LeagueTeamResponse
import com.football_score.domain.model.response.MatchResponse
import com.football_score.domain.model.response.ViewModelState
import com.football_score.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    private val _liveMatches = MutableStateFlow<ViewModelState<MatchResponse>>(ViewModelState.Empty)
    val liveMatches: StateFlow<ViewModelState<MatchResponse>> = _liveMatches

    private val _leagueTeam = MutableStateFlow<ViewModelState<LeagueTeamResponse>>(ViewModelState.Empty)
    val leagueTeam: StateFlow<ViewModelState<LeagueTeamResponse>> = _leagueTeam

    public fun getLeagueTeam() {
        _leagueTeam.value = ViewModelState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val leagueTeamResponse = useCase.getLeagueTeam()

                _leagueTeam.value = ViewModelState.Success(data = leagueTeamResponse)
            } catch (e: HttpException) {
                _leagueTeam.value = ViewModelState.Error("internet issue")
            } catch (e: IOException) {
                _leagueTeam.value = ViewModelState.Error("something wrong")
            }
        }
    }

    public fun getAllLiveMatch() {
        _liveMatches.value = ViewModelState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val liveMatchResponse = useCase.getAllLiveMatch()

                _liveMatches.value = ViewModelState.Success(data = liveMatchResponse)
            } catch (e: HttpException) {
                _liveMatches.value = ViewModelState.Error("internet issue")
            } catch (e: IOException) {
                _liveMatches.value = ViewModelState.Error("something wrong")
            }
        }
    }
}