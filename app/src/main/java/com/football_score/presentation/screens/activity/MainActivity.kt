package com.football_score.presentation.screens.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.football_score.App
import com.football_score.navigation.SetUpNavGraph
import com.football_score.ui.theme.Football_scoreTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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

