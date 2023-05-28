package com.football_score.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.football_score.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val useCases: UseCases): ViewModel() {
    private val _liveMatchState = MutableStateFlow<HomeScreenState>(HomeScreenState.Empty)
    val liveMatchState: StateFlow<HomeScreenState> = _liveMatchState

    init {
        getAllLiveMatch()
    }


    private fun getAllLiveMatch() {
        _liveMatchState.value = HomeScreenState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val liveMatchResponse = useCases.getAllLiveMatch()
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