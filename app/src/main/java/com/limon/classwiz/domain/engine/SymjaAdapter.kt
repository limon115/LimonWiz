// Author: Khalid Hasan Limon ✨
package com.limon.classwiz.domain.engine

import com.limon.classwiz.domain.model.MathToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

/**
 * ⚠️ PHONE SAFETY RATING: 10/10 📱❄️
 *
 * SAFETY DETAILS:
 * Symja parsing and evaluation can be highly resource-intensive and may cause
 * device freezing or severe thermal throttling if run on the main thread.
 *
 * PROTECTIONS IMPLEMENTED:
 * 1. Offloaded entirely to Dispatchers.Default for background computation.
 * 2. Hard withTimeout(2000L) constraint to prevent infinite evaluation loops.
 * 3. Prevents battery drain and CPU over-stressing.
 */
class SymjaAdapter {

    suspend fun evaluateExpression(tokens: List<MathToken>): String = withContext(Dispatchers.Default) {
        try {
            withTimeout(2000L) {
                val symjaString = convertToSymjaSyntax(tokens)
                // TODO: Initialize org.matheclipse.core.eval.ExprEvaluator here
                // val evaluator = ExprEvaluator(false, 100)
                // val result = evaluator.eval(symjaString)
                // return result.toString()
                "Result($symjaString)" // Placeholder 🔥
            }
        } catch (e: Exception) {
            "Syntax Error 😅"
        }
    }

    private fun convertToSymjaSyntax(tokens: List<MathToken>): String {
        // Translates UI AST tokens into Symja-readable syntax (e.g., Sqrt(2)+1/2)
        val builder = StringBuilder()
        for (token in tokens) {
            when (token) {
                is MathToken.Number -> builder.append(token.value)
                is MathToken.Operator -> builder.append(token.op)
                is MathToken.Fraction -> builder.append("(").append(convertToSymjaSyntax(token.numerator)).append(")/(").append(convertToSymjaSyntax(token.denominator)).append(")")
                is MathToken.Root -> builder.append("Sqrt(").append(convertToSymjaSyntax(token.radicand)).append(")")
                else -> {}
            }
        }
        return builder.toString()
    }
}