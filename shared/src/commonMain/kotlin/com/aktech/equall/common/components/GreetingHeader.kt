package com.aktech.equall.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aktech.equall.utils.EquallColors

/** "Good morning / Hi, Priya" header shared across the Home tabs. */
@Composable
fun GreetingHeader(
    greeting: String,
    userName: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(text = greeting, color = EquallColors.SubtleText, fontSize = 14.sp)
        Text(
            text = userName,
            color = EquallColors.PillText,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
