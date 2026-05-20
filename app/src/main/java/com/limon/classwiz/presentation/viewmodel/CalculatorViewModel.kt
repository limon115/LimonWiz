// Author: Khalid Hasan Limon
package com.limon.classwiz.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.limon.classwiz.core.MviEffect
import com.limon.classwiz.core.MviIntent
import com.limon.classwiz.core.MviState
import com.limon.classwiz.core.MviViewModel
import com.limon.classwiz.domain.engine.CursorEngine
import com.limon.classwiz.domain.engine.SymjaAdapter
import com.limon.classwiz.domain.model.CursorState
import com.limon.classwiz.domain.model.MathToken
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class CalcIntent : MviIntent {
    data class InputNumber(val num: String) : CalcIntent()
    data class InputOperator(val op: String) : CalcIntent()
    object Evaluate : CalcIntent()
    object MoveLeft : CalcIntent()
    object MoveRight : CalcIntent()
}

data class CalcState(
    val tokens: List<MathToken> = emptyList(),
    val cursorState: CursorState = CursorState(),
    val result: String = "",
    val isShiftActive: Boolean = false,
    val isAlphaActive: Boolean = false
) : MviState

sealed class CalcEffect : MviEffect {
    object TriggerHaptic : CalcEffect()
}

class CalculatorViewModel(
    private val cursorEngine: CursorEngine = CursorEngine(),
    private val symjaAdapter: SymjaAdapter = SymjaAdapter()
) : ViewModel(), MviViewModel<CalcIntent, CalcState, CalcEffect> {

    private val _state = MutableStateFlow(CalcState())
    override val state: StateFlow<CalcState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<CalcEffect>()
    override val effect: SharedFlow<CalcEffect> = _effect

    override fun handleIntent(intent: CalcIntent) {
        viewModelScope.launch { _effect.emit(CalcEffect.TriggerHaptic) }
        when (intent) {
            is CalcIntent.InputNumber -> insertToken(MathToken.Number(intent.num))
            is CalcIntent.InputOperator -> insertToken(MathToken.Operator(intent.op))
            is CalcIntent.MoveLeft -> moveCursorLeft()
            is CalcIntent.MoveRight -> moveCursorRight()
            is CalcIntent.Evaluate -> evaluateExpression()
        }
    }

    private fun insertToken(token: MathToken) {
        val (newTokens, newCursor) = cursorEngine.insertToken(_state.value.tokens, _state.value.cursorState, token)
        _state.value = _state.value.copy(tokens = newTokens, cursorState = newCursor)
    }

    private fun moveCursorLeft() {
        _state.value = _state.value.copy(cursorState = cursorEngine.moveLeft(_state.value.tokens, _state.value.cursorState))
    }

    private fun moveCursorRight() {
        _state.value = _state.value.copy(cursorState = cursorEngine.moveRight(_state.value.tokens, _state.value.cursorState))
    }

    private fun evaluateExpression() {
        viewModelScope.launch {
            val evalResult = symjaAdapter.evaluateExpression(_state.value.tokens)
            _state.value = _state.value.copy(result = evalResult)
        }
    }
}
