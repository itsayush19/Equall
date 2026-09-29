package com.aktech.equall.screens.HomeScreen.presentation.review

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aktech.equall.common.components.GreetingHeader
import com.aktech.equall.common.components.TrustIqCard
import com.aktech.equall.domain.model.ApplicationSummary
import com.aktech.equall.domain.model.ReviewInfo
import com.aktech.equall.domain.model.ReviewStepInfo
import com.aktech.equall.domain.model.ReviewStepState
import com.aktech.equall.utils.EquallColors

@Composable
fun ReviewContent(data: ReviewInfo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GreetingHeader(greeting = data.greeting, userName = data.userName)
        SummaryCard(data.summary)
        ProgressCard(title = data.progressTitle, steps = data.steps)
        TrustIqCard(data.trustIq)
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun SummaryCard(summary: ApplicationSummary) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(EquallColors.Brand)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = summary.label,
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.White.copy(alpha = 0.18f))
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                if (summary.showBadgeDot) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFF5B301)),
                    )
                }
                Text(text = summary.badgeText, color = Color.White, fontSize = 12.sp)
            }
        }

        Text(
            text = summary.amountDisplay,
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = summary.subtitle,
            color = Color.White.copy(alpha = 0.85f),
            fontSize = 14.sp,
        )
    }
}

@Composable
private fun ProgressCard(title: String, steps: List<ReviewStepInfo>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(EquallColors.Surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = title,
            color = EquallColors.SubtleText,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        steps.forEachIndexed { index, step ->
            StepRow(step = step, isLast = index == steps.lastIndex)
        }
    }
}

@Composable
private fun StepRow(step: ReviewStepInfo, isLast: Boolean) {
    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            StepIcon(step.state)
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .weight(1f)
                        .background(EquallColors.Border),
                )
            }
        }

        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = if (isLast) 0.dp else 18.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = step.title,
                    color = if (step.state == ReviewStepState.CURRENT) EquallColors.Brand else EquallColors.PillText,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                if (step.badgeText != null) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(EquallColors.IconTileBg)
                            .padding(horizontal = 8.dp, vertical = 3.dp),
                    ) {
                        Text(
                            text = step.badgeText,
                            color = EquallColors.Brand,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
            Text(text = step.subtitle, color = EquallColors.NavInactive, fontSize = 13.sp)
            if (step.timeLabel != null) {
                Text(text = step.timeLabel, color = EquallColors.SubtleText, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun StepIcon(state: ReviewStepState) {
    when (state) {
        ReviewStepState.DONE -> Box(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .background(EquallColors.ScoreGreen),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "✓", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }

        ReviewStepState.CURRENT -> Box(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .border(2.dp, EquallColors.Brand, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(EquallColors.Brand),
            )
        }

        ReviewStepState.PENDING -> Box(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .border(2.dp, EquallColors.Border, CircleShape),
        )
    }
}
