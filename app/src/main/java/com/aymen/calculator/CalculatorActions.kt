package com.aymen.calculator

sealed class CalculatorActions {
    data class Number(val number: String) : CalculatorActions()
    data class Operation(val calculatorOperation: CalculatorOperation) : CalculatorActions()
    data object Clear : CalculatorActions()
    data object Delete : CalculatorActions()
    data object Decimal : CalculatorActions()
    data object Calculate : CalculatorActions()
}