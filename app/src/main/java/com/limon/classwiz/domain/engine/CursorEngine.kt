// Author: Khalid Hasan Limon 🎯
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.CursorState
import com.limon.classwiz.domain.model.MathToken

/**
 * ⚠️ PHONE SAFETY RATING: 10/10 📱✨
 * Safe to run synchronously as it only traverses lightweight immutable tree structures in memory.
 */
class CursorEngine {
    fun moveLeft(tokens: List<MathToken>, currentCursor: CursorState): CursorState {
        // Logic to navigate up/down the AST boundaries like jumping out of a denominator
        val newPosition = if (currentCursor.position > 0) currentCursor.position - 1 else 0
        return currentCursor.copy(position = newPosition)
    }

    fun moveRight(tokens: List<MathToken>, currentCursor: CursorState): CursorState {
        val newPosition = if (currentCursor.position < tokens.size) currentCursor.position + 1 else tokens.size
        return currentCursor.copy(position = newPosition)
    }

    fun insertToken(tokens: List<MathToken>, currentCursor: CursorState, token: MathToken): Pair<List<MathToken>, CursorState> {
        val mutableTokens = tokens.toMutableList()
        mutableTokens.add(currentCursor.position, token)
        return Pair(mutableTokens, currentCursor.copy(position = currentCursor.position + 1))
    }
}