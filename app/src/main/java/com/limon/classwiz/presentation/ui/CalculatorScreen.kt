// Author: Khalid Hasan Limon 🎨
package com.limon.classwiz.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.limon.classwiz.presentation.viewmodel.CalcIntent
import com.limon.classwiz.presentation.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // True-black background for signature aesthetic 💎
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Display Area
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            ExpressionRenderer(tokens = state.tokens)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = state.result, fontSize = 32.sp, color = Color.Green)
        }

        // Keypad Area (Simplified for Initial Scope)
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { viewModel.handleIntent(CalcIntent.InputNumber("7")) }) { Text("7") }
                Button(onClick = { viewModel.handleIntent(CalcIntent.InputNumber("8")) }) { Text("8") }
                Button(onClick = { viewModel.handleIntent(CalcIntent.InputNumber("9")) }) { Text("9") }
                Button(onClick = { viewModel.handleIntent(CalcIntent.InputOperator("+")) }) { Text("+") }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { viewModel.handleIntent(CalcIntent.MoveLeft) }) { Text("<") }
                Button(onClick = { viewModel.handleIntent(CalcIntent.MoveRight) }) { Text(">") }
                Button(onClick = { viewModel.handleIntent(CalcIntent.Evaluate) }) { Text("=") }
            }
        }
    }
}