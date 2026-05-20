// Author: Khalid Hasan Limon
package com.limon.classwiz.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onAppSelected: (String) -> Unit) {
    // Extracted directly from the ClassWiz CW series architecture logic
    val calculatorApps = listOf(
        "Calculate", "Complex", "Base-N", "Matrix",
        "Vector", "Statistics", "Distribution", "Spreadsheet",
        "Table", "Equation", "Inequality", "Ratio", "Math Box"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "HOME",
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(calculatorApps) {
                appName -> AppIcon(appName = appName, onClick = { onAppSelected(appName) })
            }
        }
    }
}

@Composable
fun AppIcon(appName: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .aspectRatio(1.5f)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x33FFFFFF))
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Text(
            text = appName,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif
        )
    }
}
