// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.CalculatorMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ModeManager {
    private val _currentMode = MutableStateFlow<CalculatorMode>(CalculatorMode.COMP)
    val currentMode: StateFlow<CalculatorMode> = _currentMode.asStateFlow()

    fun setMode(mode: CalculatorMode) {
        _currentMode.value = mode
    }

    fun getAvailableModes(): List<CalculatorMode> {
        return listOf(
            CalculatorMode.COMP,
            CalculatorMode.CMPLX,
            CalculatorMode.STAT,
            CalculatorMode.BASE_N,
            CalculatorMode.TABLE,
            CalculatorMode.MATRIX,
            CalculatorMode.VECTOR,
            CalculatorMode.EQN
        )
    }
}
