// Author: Khalid Hasan Limon
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.MathToken

class MathTokenFormatter {
    fun formatResultToTokens(resultString: String): List<MathToken> {
        return listOf(MathToken.Number(resultString))
    }

    fun parseInputString(input: String): List<MathToken> {
        return input.map { char ->
            if (char.isDigit() || char == '.') {
                MathToken.Number(char.toString())
            } else {
                MathToken.Operator(char.toString())
            }
        }
    }
}
