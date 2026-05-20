// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.ModifierState

class InputSystem {
    var currentState: ModifierState = ModifierState.NORMAL
        private set

    fun toggleShift() {
        currentState = if (currentState == ModifierState.SHIFT) ModifierState.NORMAL else ModifierState.SHIFT
    }

    fun toggleAlpha() {
        currentState = if (currentState == ModifierState.ALPHA) ModifierState.NORMAL else ModifierState.ALPHA
    }

    fun resetModifier() {
        currentState = ModifierState.NORMAL
    }
}
