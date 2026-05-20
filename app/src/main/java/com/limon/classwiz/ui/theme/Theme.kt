// Author: Khalid Hasan Limon
package com.limon.classwiz.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val TrueBlackColorScheme = darkColorScheme(
    background = Color.Black,
    surface = Color(0x33FFFFFF), // Glassmorphism translucent surface
    onBackground = Color.White,
    onSurface = Color.White,
    primary = Color(0xFFFFFFFF), // High contrast primary text
    secondary = Color(0x80FFFFFF) // Dimmed secondary elements
)

val ProfessionalSerifTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )
)

@Composable
fun ClassWizTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = TrueBlackColorScheme,
        typography = ProfessionalSerifTypography,
        content = content
    )
}
