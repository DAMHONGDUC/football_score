package com.football_score.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.football_score.repository.LiveMatchRepository
import com.football_score.viewmodel.state.MatchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException
import org.json.JSONObject
import org.json.JSONTokener
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
            }
            catch (e: HttpException)
            {
                _liveMatchState.value = MatchState.Error("internet issue")
            }
            catch (e: IOException)
            {
                _liveMatchState.value = MatchState.Error("somethign wrong")
            }
        }
    }
}