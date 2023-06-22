package com.football_score.presentation.components

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.football_score.App

@Composable
fun AppHeader(app: App, setIsReload: (isReload: Boolean) -> Unit) {
    val (isEnable, setIsEnable) = remember {
        mutableStateOf(true)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Live Scores",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground
        )
        Row()
        {
            IconButton(
                onClick = {
                    setIsReload(true)
                    setIsEnable(false)

                    val r = Runnable {
                        setIsEnable(true)
                    }
                    Handler(Looper.getMainLooper()).postDelayed(r, 3000)
                },
                enabled = isEnable
            ) {
                Icon(
                    imageVector = Icons.Filled.Autorenew,
                    contentDescription = "Autorenew Icon",
                    modifier = Modifier.size(24.dp),
                    tint = if (isEnable) Color(0xFF1C1B1F) else Color(0xFF938F99)
                )
            }
            IconButton(onClick = { app.changeTheme() }) {
                Icon(
                    imageVector = Icons.Filled.DarkMode,
                    contentDescription = "Mode Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}