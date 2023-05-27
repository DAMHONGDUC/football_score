package com.football_score.viewmodel

import androidx.lifecycle.ViewModel
import com.football_score.data.repository.LiveMatchRepository
import com.football_score.viewmodel.state.MatchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

@HiltViewModel
class LiveMatchViewModel @Inject constructor(private val liveMatchRepository: LiveMatchRepository): ViewModel() {
    private val _liveMatchState = MutableStateFlow<MatchState>(MatchState.Empty)
    val liveMatchState: StateFlow<MatchState> = _liveMatchState

    init {
        getAllLiveMatch()
    }


    private fun getAllLiveMatch() {
        _liveMatchState.value = MatchState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val liveMatchResponse = liveMatchRepository.getAllLiveMatch()
                _liveMatchState.value = MatchState.Success(liveMatchResponse)

                //Log.d("liveMatchResponse", liveMatchResponse.toString());
            }
            catch (e: HttpException)
            {
                _liveMatchState.value = MatchState.Error("internet issue")
            }
            catch (e: IOException)
            {
                _liveMatchState.value = MatchState.Error("something wrong")
                //Log.d("liveMatchResponse", e.toString())
            }
        }
    }
}