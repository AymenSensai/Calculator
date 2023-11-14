package com.aymen.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {

    val scrollState = rememberScrollState()

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .verticalScroll(scrollState)
        ) {
            val boldText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.outline)) {
                    append(state.number1)
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append((state.operation?.symbol ?: ""))
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.outline)) {
                    append(state.number2)
                }
            }
            Text(
                text = boldText,
                textAlign = TextAlign.End,
                maxLines = 2,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Text(
                text = state.result,
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.outline,
                maxLines = 2,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.onSurface)
                    .navigationBarsPadding()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CalculatorButton(
                        symbol = "C",
                        symbolColor = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Clear) }
                    )
                    CalculatorButton(
                        symbol = "%",
                        symbolColor = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Operation(CalculatorOperation.Percentage)) }
                    )
                    CalculatorIconButton(
                        icon = R.drawable.backspace_icon,
                        iconColor = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Delete) }
                    )
                    CalculatorButton(
                        symbol = "/",
                        symbolColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Operation(CalculatorOperation.Divide)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CalculatorButton(
                        symbol = "7",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("7")) }
                    )
                    CalculatorButton(
                        symbol = "8",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("8")) }
                    )
                    CalculatorButton(
                        symbol = "9",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("9")) }
                    )
                    CalculatorButton(
                        symbol = "x",
                        symbolColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Operation(CalculatorOperation.Multiply)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CalculatorButton(
                        symbol = "4",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("4")) }
                    )
                    CalculatorButton(
                        symbol = "5",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("5")) }
                    )
                    CalculatorButton(
                        symbol = "6",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("6")) }
                    )
                    CalculatorButton(
                        symbol = "-",
                        symbolColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Operation(CalculatorOperation.Subtract)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CalculatorButton(
                        symbol = "1",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("1")) }
                    )
                    CalculatorButton(
                        symbol = "2",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("2")) }
                    )
                    CalculatorButton(
                        symbol = "3",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("3")) }
                    )
                    CalculatorButton(
                        symbol = "+",
                        symbolColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Operation(CalculatorOperation.Add)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CalculatorButton(
                        symbol = "00",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("00")) }
                    )
                    CalculatorButton(
                        symbol = "0",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Number("0")) }
                    )
                    CalculatorButton(
                        symbol = ".",
                        symbolColor = MaterialTheme.colorScheme.outline,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Decimal) }
                    )
                    CalculatorButton(
                        symbol = "=",
                        symbolColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = { onAction(CalculatorActions.Calculate) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CalculatorPreview() {
    val state = CalculatorState(number1 = "12", number2 = "02", operation = null)
    Calculator(
        state = state,
        onAction = {}
    )
}