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
    private val _liveMatchState = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)
    private val _hotMatchState = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)

    val liveMatchState: StateFlow<HomeScreenState> = _liveMatchState
    val hotMatchState: StateFlow<HomeScreenState> = _hotMatchState

    init {
        getAllLiveMatch()
    }

    private fun getAllHotMatch()
    {

    }


    private fun getAllLiveMatch() {
        _liveMatchState.value = HomeScreenState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val liveMatchResponse = useCase.getAllLiveMatch()
                _liveMatchState.value = HomeScreenState.Success(liveMatchResponse)
            }
            catch (e: HttpException)
            {
                _liveMatchState.value = HomeScreenState.Error("internet issue")
            }
            catch (e: IOException)
            {
                _liveMatchState.value = HomeScreenState.Error("something wrong")
            }
        }
    }
}