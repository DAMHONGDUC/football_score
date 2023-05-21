package com.football_score.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.football_score.R

val CustomFontFamily = FontFamily(
    Font(R.font.poppins_bold ,FontWeight.Bold),
    Font(R.font.poppins_medium,FontWeight.Medium),
    Font(R.font.poppins_medium,FontWeight.Normal),
    Font(R.font.poppins_semi_bold,FontWeight.SemiBold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = CustomFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
    ),
    h3 = TextStyle(
        fontFamily = CustomFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    ),
    h4 = TextStyle(
        fontFamily = CustomFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    ),
    h5 = TextStyle(
        fontFamily = CustomFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    ),
)