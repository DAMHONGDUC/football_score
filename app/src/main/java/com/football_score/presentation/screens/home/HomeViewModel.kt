package com.football_score.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class HomeViewModel @Inject constructor( private val useCase: UseCase): ViewModel() {
    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)
    val state: StateFlow<HomeScreenState> = _state

    public fun getData() {
        _state.value = HomeScreenState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val liveMatchResponse = useCase.getAllLiveMatch()
                val leagueTeamResponse = useCase.getLeagueTeam()

                _state.value = HomeScreenState.Success(liveMatchResponse, leagueTeamResponse)
            }
            catch (e: HttpException)
            {
                _state.value = HomeScreenState.Error("internet issue")
            }
            catch (e: IOException)
            {
                _state.value = HomeScreenState.Error("something wrong")
            }
        }
    }
}