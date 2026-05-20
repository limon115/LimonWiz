// Author: Khalid Hasan Limon
package com.limon.classwiz.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.limon.classwiz.presentation.ui.components.GlassButton
import com.limon.classwiz.presentation.viewmodel.CalcIntent

@Composable
fun Keypad(
    onIntent: (CalcIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            GlassButton("SHIFT", onClick = { /* TODO */ }, modifier = Modifier.weight(1f), color = Color(0x33D4AF37))
            GlassButton("ALPHA", onClick = { /* TODO */ }, modifier = Modifier.weight(1f), color = Color(0x33E91E63))
            GlassButton("LEFT", onClick = { onIntent(CalcIntent.MoveLeft) }, modifier = Modifier.weight(1f))
            GlassButton("RIGHT", onClick = { onIntent(CalcIntent.MoveRight) }, modifier = Modifier.weight(1f))
            GlassButton("MODE", onClick = { /* TODO */ }, modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            GlassButton("7", onClick = { onIntent(CalcIntent.InputNumber("7")) }, modifier = Modifier.weight(1f))
            GlassButton("8", onClick = { onIntent(CalcIntent.InputNumber("8")) }, modifier = Modifier.weight(1f))
            GlassButton("9", onClick = { onIntent(CalcIntent.InputNumber("9")) }, modifier = Modifier.weight(1f))
            GlassButton("DEL", onClick = { /* TODO */ }, modifier = Modifier.weight(1f), color = Color(0x55FF5555))
            GlassButton("AC", onClick = { /* TODO */ }, modifier = Modifier.weight(1f), color = Color(0x55FF5555))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            GlassButton("4", onClick = { onIntent(CalcIntent.InputNumber("4")) }, modifier = Modifier.weight(1f))
            GlassButton("5", onClick = { onIntent(CalcIntent.InputNumber("5")) }, modifier = Modifier.weight(1f))
            GlassButton("6", onClick = { onIntent(CalcIntent.InputNumber("6")) }, modifier = Modifier.weight(1f))
            GlassButton("*", onClick = { onIntent(CalcIntent.InputOperator("*")) }, modifier = Modifier.weight(1f))
            GlassButton("/", onClick = { onIntent(CalcIntent.InputOperator("/")) }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            GlassButton("1", onClick = { onIntent(CalcIntent.InputNumber("1")) }, modifier = Modifier.weight(1f))
            GlassButton("2", onClick = { onIntent(CalcIntent.InputNumber("2")) }, modifier = Modifier.weight(1f))
            GlassButton("3", onClick = { onIntent(CalcIntent.InputNumber("3")) }, modifier = Modifier.weight(1f))
            GlassButton("+", onClick = { onIntent(CalcIntent.InputOperator("+")) }, modifier = Modifier.weight(1f))
            GlassButton("-", onClick = { onIntent(CalcIntent.InputOperator("-")) }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            GlassButton("0", onClick = { onIntent(CalcIntent.InputNumber("0")) }, modifier = Modifier.weight(1f))
            GlassButton(".", onClick = { onIntent(CalcIntent.InputNumber(".")) }, modifier = Modifier.weight(1f))
            GlassButton("x10^x", onClick = { /* TODO */ }, modifier = Modifier.weight(1f))
            GlassButton("Ans", onClick = { /* TODO */ }, modifier = Modifier.weight(1f))
            GlassButton("=", onClick = { onIntent(CalcIntent.Evaluate) }, modifier = Modifier.weight(1f), color = Color(0x554CAF50))
        }
    }
}
