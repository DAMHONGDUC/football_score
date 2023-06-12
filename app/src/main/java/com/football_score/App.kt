package com.football_score

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import androidx.compose.runtime.mutableStateOf

@HiltAndroidApp
class App : Application() {
    val isDark = mutableStateOf(false)

    fun changeTheme() {
        isDark.value = !isDark.value;
    }

}