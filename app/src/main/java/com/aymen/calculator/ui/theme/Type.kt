package com.aymen.calculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aymen.calculator.R

val fonts = FontFamily(
    Font(R.font.space_grotesk_regular, weight = FontWeight.Normal),
    Font(R.font.space_grotesk_bold, weight = FontWeight.Bold)
)

val Typography = Typography(

    headlineMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    )

)