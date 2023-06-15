package com.football_score

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.football_score.navigation.SetUpNavGraph
import com.football_score.ui.theme.Football_scoreTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// architecture: https://paulallies.medium.com/clean-architecture-in-the-flavour-of-jetpack-compose-dd4b0016f815
// dependencies injection: https://medium.com/@myofficework000/dependency-injection-dagger-hilt-in-android-14a7f03050e8
// dagger - hilt anotation: https://developer.android.com/static/images/training/dependency-injection/hilt-annotations.pdf

// @InstallIn: chỉ ra Hilt-generated container

// @Inject - constructor: nói cho dagger-hilt biết cái constructor nào dùng để tạo instance & những dependencies của constructor
// @Inject - field: ko thể private, có chức năng lấy các field ở các class có @Inject trong class  @AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            Football_scoreTheme(darkTheme = app.isDark.value) {
                SetUpNavGraph(navController = navController, app = app)
            }
        }
    }
}

