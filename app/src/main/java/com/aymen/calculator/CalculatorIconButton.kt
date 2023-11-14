package com.aymen.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorIconButton(
    icon: Int,
    iconColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.onSurfaceVariant)
            .clickable { onClick() }
            .aspectRatio(1f)
            .then(modifier)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Icon Button",
            tint = iconColor
        )
    }

}

@Preview
@Composable
fun CalculatorIconButtonPreview() {
    CalculatorIconButton(
        R.drawable.backspace_icon,
        MaterialTheme.colorScheme.secondary,
        onClick = {})
}