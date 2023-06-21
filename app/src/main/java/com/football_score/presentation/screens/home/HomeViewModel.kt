package com.football_score.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football_score.domain.model.response.MatchResponse
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
    private val _liveMatches = MutableStateFlow<HomeScreenState<MatchResponse>>(HomeScreenState.Empty)
    val liveMatches: StateFlow<HomeScreenState<MatchResponse>> = _liveMatches

//    private val _hotMatch = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)
//    val hotMatch: StateFlow<HomeScreenState> = _hotMatch
//
//    private val _leagueTeam = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)
//    val leagueTeam: StateFlow<HomeScreenState> = _leagueTeam

//    public fun getLeagueTeam() {
//        _leagueTeam.value = HomeScreenState.Loading
//
//        viewModelScope.launch(Dispatchers.IO) {
//
//            try {
//                val leagueTeamResponse = useCase.getLeagueTeam()
//
//                _leagueTeam.value = HomeScreenState.Success(data = leagueTeamResponse)
//            } catch (e: HttpException) {
//                _leagueTeam.value = HomeScreenState.Error("internet issue")
//            } catch (e: IOException) {
//                _leagueTeam.value = HomeScreenState.Error("something wrong")
//            }
//        }
//    }

    public fun getAllLiveMatch() {
        _liveMatches.value = HomeScreenState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val liveMatchResponse = useCase.getAllLiveMatch()

                _liveMatches.value = HomeScreenState.Success(data = liveMatchResponse)
            } catch (e: HttpException) {
                _liveMatches.value = HomeScreenState.Error("internet issue")
            } catch (e: IOException) {
                _liveMatches.value = HomeScreenState.Error("something wrong")
            }
        }
    }
}