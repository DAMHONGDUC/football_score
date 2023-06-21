package com.football_score

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import androidx.compose.runtime.mutableStateOf

// architecture: https://paulallies.medium.com/clean-architecture-in-the-flavour-of-jetpack-compose-dd4b0016f815
// dependencies injection: https://medium.com/@myofficework000/dependency-injection-dagger-hilt-in-android-14a7f03050e8
// dagger - hilt anotation: https://developer.android.com/static/images/training/dependency-injection/hilt-annotations.pdf

// @InstallIn: chỉ ra Hilt-generated container

// @Inject - constructor: nói cho dagger-hilt biết cái constructor nào dùng để tạo instance & những dependencies của constructor
// @Inject - field: ko thể private, có chức năng lấy các field ở các class có @Inject trong class  @AndroidEntryPoint

// https://github.com/piashcse/Hilt-MVVM-Compose-Movie

// UI: https://dribbble.com/shots/20008455-Live-Score-Mobile-App

// FootBall API: https://www.api-football.com/documentation-v3

// call multi API: https://inside.caratlane.com/ways-to-hit-multiple-api-calls-efficiently-with-kotlin-coroutine-threads-34a6cedfec68

// kotlin coroutine: https://medium.com/@krsobhana10/what-is-kotlin-coroutines-and-how-will-it-benefit-us-fb6072bbb313

// React to Jetpack Compose: https://tigeroakes.com/posts/react-to-compose-dictionary/

@HiltAndroidApp
class App : Application() {
    val isDark = mutableStateOf(false)

    fun changeTheme() {
        isDark.value = !isDark.value;
    }

}