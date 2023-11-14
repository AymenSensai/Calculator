package com.aymen.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    /**
     * Handles the user action performed on the calculator.
     * @param action The action to be performed.
     */
    fun onAction(action: CalculatorActions) {
        when (action) {
            is CalculatorActions.Number -> enterNumber(action.number)
            is CalculatorActions.Operation -> enterOperation(action.calculatorOperation)
            CalculatorActions.Clear -> state = CalculatorState()
            CalculatorActions.Delete -> delete()
            CalculatorActions.Decimal -> enterDecimal()
            CalculatorActions.Calculate -> calculate()
        }
    }


    /**
     * Updates the current operation in the calculator state.
     * @param operation The operation to be set.
     */
    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    /**
     * Calculates the result based on the current state of the calculator.
     */
    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Percentage -> number1 * number2 / 100
                null -> return
            }
            state = state.copy(
                number1 = "",
                number2 = "",
                operation = null,
                result = result.toString().take(15)
            )
        }
    }

    /**
     * Deletes the last entered character or clears the current state.
     */
    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    /**
     * Adds a decimal point to the current number being entered.
     */
    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    /**
     * Adds a number to the current number being entered.
     * @param number The number to be added.
     */
    private fun enterNumber(number: String) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}