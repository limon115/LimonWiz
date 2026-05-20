// Author: Khalid Hasan Limon
package com.limon.classwiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.limon.classwiz.presentation.ui.CalculatorScreen
import com.limon.classwiz.presentation.viewmodel.CalculatorViewModel
import com.limon.classwiz.ui.theme.ClassWizTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CalculatorViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassWizTheme {
                CalculatorScreen(viewModel = viewModel)
            }
        }
    }
}
