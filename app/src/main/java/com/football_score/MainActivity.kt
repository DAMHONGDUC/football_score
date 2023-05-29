package com.football_score

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.football_score.navigation.SetUpNavGraph
import com.football_score.ui.theme.Football_scoreTheme
import dagger.hilt.android.AndroidEntryPoint

// architecture: https://paulallies.medium.com/clean-architecture-in-the-flavour-of-jetpack-compose-dd4b0016f815

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Football_scoreTheme(darkTheme = true) {
                SetUpNavGraph(navController = navController)
            }
        }
    }
}

