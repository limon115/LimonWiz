// Author: Khalid Hasan Limon
package com.limon.classwiz.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.limon.classwiz.domain.engine.MenuManager
import com.limon.classwiz.domain.model.MenuNode

@Composable
fun MenuOverlay(
    menuManager: MenuManager,
    onActionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val currentFolder by menuManager.currentFolder.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xEE000000))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = currentFolder.title,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn {
                items(currentFolder.children) {
                    node -> MenuRow(
                        node = node,
                        onClick = {
                            when (node) {
                                is MenuNode.Folder -> menuManager.navigateInto(node)
                                is MenuNode.Action -> onActionSelected(node.actionId)
                                is MenuNode.Toggle -> onActionSelected(node.toggleId)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun MenuRow(node: MenuNode, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Text(
            text = node.title,
            color = Color.LightGray,
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif
        )
    }
}
