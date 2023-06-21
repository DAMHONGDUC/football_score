package com.football_score.domain.model.response


sealed class ViewModelState<out T>() {
    object Empty : ViewModelState<Nothing>()
    object Loading : ViewModelState<Nothing>()
    class Success<out T>(val data: T) : ViewModelState<T>()
    class Error(val message: String) : ViewModelState<Nothing>()
}