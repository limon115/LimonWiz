// Author: Khalid Hasan Limon
package com.limon.classwiz.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.limon.classwiz.domain.model.CalculatorMode
import com.limon.classwiz.domain.model.ModifierState

@Composable
fun TopBar(
    modifierState: ModifierState,
    currentMode: CalculatorMode,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0x11FFFFFF))
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            if (modifierState == ModifierState.SHIFT) {
                Text(text = "S", color = Color(0xFFD4AF37), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            } else {
                Spacer(modifier = Modifier.width(8.dp))
            }

            if (modifierState == ModifierState.ALPHA) {
                Text(text = "A", color = Color(0xFFE91E63), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            } else {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        Text(
            text = currentMode.displayName,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}
