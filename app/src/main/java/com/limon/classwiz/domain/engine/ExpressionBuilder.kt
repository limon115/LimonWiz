// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.CursorState
import com.limon.classwiz.domain.model.MathToken

class ExpressionBuilder {
    /**
     * Advanced insertion logic for textbook layout.
     * Handles placing empty boxes when fractions or roots are triggered.
     */
    fun insertFraction(tokens: List<MathToken>, cursor: CursorState): Pair<List<MathToken>, CursorState> {
        val emptyNumerator = listOf(MathToken.Number(""))
        val emptyDenominator = listOf(MathToken.Number(""))
        val fractionToken = MathToken.Fraction(emptyNumerator, emptyDenominator)

        val mutableTokens = tokens.toMutableList()
        mutableTokens.add(cursor.position, fractionToken)

        // Move cursor INSIDE the numerator of the new fraction
        val newCursorPath = cursor.path + listOf(cursor.position, 0) // 0 denotes numerator index path
        return Pair(mutableTokens, cursor.copy(position = 0, path = newCursorPath))
    }

    fun insertSquareRoot(tokens: List<MathToken>, cursor: CursorState): Pair<List<MathToken>, CursorState> {
        val emptyRadicand = listOf(MathToken.Number(""))
        val rootToken = MathToken.Root(degree = null, radicand = emptyRadicand)

        val mutableTokens = tokens.toMutableList()
        mutableTokens.add(cursor.position, rootToken)

        val newCursorPath = cursor.path + listOf(cursor.position, 0)
        return Pair(mutableTokens, cursor.copy(position = 0, path = newCursorPath))
    }
}
