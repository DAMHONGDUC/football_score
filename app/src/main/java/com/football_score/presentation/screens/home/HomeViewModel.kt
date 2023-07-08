package com.football_score.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football_score.domain.model.response.LeagueTeamResponse
import com.football_score.domain.model.response.MatchResponse
import com.football_score.domain.model.response.ViewModelState
import com.football_score.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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

    private val _hotMatches = MutableStateFlow<ViewModelState<MatchResponse>>(ViewModelState.Empty)
    val hotMatches: StateFlow<ViewModelState<MatchResponse>> = _hotMatches

    private val _leagueTeam =
        MutableStateFlow<ViewModelState<LeagueTeamResponse>>(ViewModelState.Empty)
    val leagueTeam: StateFlow<ViewModelState<LeagueTeamResponse>> = _leagueTeam

    init {
        getAllLiveMatch();
        getLeagueTeam();
    }

    fun getLeagueTeam() {
        _leagueTeam.value = ViewModelState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            val call = async { useCase.getLeagueTeam() }

            try {
                val leagueTeamResponse = call.await()

                _leagueTeam.value = ViewModelState.Success(data = leagueTeamResponse)
            } catch (e: HttpException) {
                _leagueTeam.value = ViewModelState.Error("internet issue")
            } catch (e: IOException) {
                _leagueTeam.value = ViewModelState.Error("something wrong")
            }
        }
    }

    fun getAllLiveMatch() {
        _liveMatches.value = ViewModelState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            val call = async { useCase.getAllLiveMatch() }

            try {
                val liveMatchResponse = call.await()

                _liveMatches.value = ViewModelState.Success(data = liveMatchResponse)
            } catch (e: HttpException) {
                _liveMatches.value = ViewModelState.Error("Internet issue")
            } catch (e: IOException) {
                _liveMatches.value = ViewModelState.Error("Something wrong")
            }
        }
    }

    fun getHotMatches() {
        _hotMatches.value = ViewModelState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            val call = async { useCase.getHotMatches() }

            try {
                val hotMatchesResponse = call.await()

                _hotMatches.value = ViewModelState.Success(data = hotMatchesResponse)
            } catch (e: HttpException) {
                _hotMatches.value = ViewModelState.Error("Internet issue")
            } catch (e: IOException) {
                _hotMatches.value = ViewModelState.Error("Something wrong")
            }
        }
    }
}