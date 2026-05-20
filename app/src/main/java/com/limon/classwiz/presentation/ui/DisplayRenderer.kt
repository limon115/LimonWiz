// Author: Khalid Hasan Limon 😎
package com.limon.classwiz.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.limon.classwiz.domain.model.MathToken

/**
 * Recursive Jetpack Compose renderer to draw textbook-style math expressions.
 * Achieves the natural display feel of ClassWiz! ✨
 */
@Composable
fun ExpressionRenderer(tokens: List<MathToken>, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        tokens.forEach { token ->
            when (token) {
                is MathToken.Number -> Text(text = token.value, fontSize = 24.sp, color = Color.White)
                is MathToken.Operator -> Text(text = " ${token.op} ", fontSize = 24.sp, color = Color.White)
                is MathToken.Fraction -> FractionRenderer(token)
                is MathToken.Root -> RootRenderer(token)
                else -> Text(text = "?", color = Color.Red)
            }
        }
    }
}

@Composable
fun FractionRenderer(fraction: MathToken.Fraction) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 4.dp)) {
        ExpressionRenderer(tokens = fraction.numerator)
        // Horizontal rule for fraction bar
        Box(modifier = Modifier.height(1.dp).fillMaxWidth().background(Color.White).padding(vertical = 2.dp))
        ExpressionRenderer(tokens = fraction.denominator)
    }
}

@Composable
fun RootRenderer(root: MathToken.Root) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "√(", fontSize = 24.sp, color = Color.White) // Simplified layout for step 1 🚀
        ExpressionRenderer(tokens = root.radicand)
        Text(text = ")", fontSize = 24.sp, color = Color.White)
    }
}