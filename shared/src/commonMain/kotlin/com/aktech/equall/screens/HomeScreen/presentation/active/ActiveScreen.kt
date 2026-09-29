package com.aktech.equall.screens.HomeScreen.presentation.active

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
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
import com.aktech.equall.domain.model.ActiveLoan
import com.aktech.equall.domain.model.LoanDetailRow
import com.aktech.equall.domain.model.LoanSummary
import com.aktech.equall.domain.model.NextEmi
import com.aktech.equall.utils.EquallColors
import com.aktech.equall.utils.EquallIcons

@Composable
fun ActiveContent(data: ActiveLoan) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GreetingHeader(greeting = data.greeting, userName = data.userName)
        SummaryCard(data.summary)
        NextEmiCard(data.nextEmi)
        DetailsCard(data.details)
        TrustIqCard(data.trustIq)
    }
}

@Composable
private fun SummaryCard(summary: LoanSummary) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(EquallColors.DarkCard)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = summary.label,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.White.copy(alpha = 0.14f))
                    .padding(horizontal = 12.dp, vertical = 5.dp),
            ) {
                Text(text = summary.badgeText, color = Color.White, fontSize = 12.sp)
            }
        }

        Text(
            text = summary.outstandingDisplay,
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
        )

        EmiProgressBar(paid = summary.paid, total = summary.total)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = summary.paidLabel, color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
            Text(text = summary.remainingLabel, color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
        }
    }
}

@Composable
private fun EmiProgressBar(paid: Int, total: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        repeat(total) { index ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(
                        if (index < paid) Color.White else Color.White.copy(alpha = 0.22f),
                    ),
            )
        }
    }
}

@Composable
private fun NextEmiCard(nextEmi: NextEmi) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(EquallColors.NextEmiBg)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Icon(
            imageVector = EquallIcons.Clock,
            contentDescription = null,
            tint = EquallColors.NextEmiText,
            modifier = Modifier.size(22.dp),
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Text(
                text = nextEmi.title,
                color = EquallColors.NextEmiText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = nextEmi.subtitle,
                color = EquallColors.NextEmiText.copy(alpha = 0.8f),
                fontSize = 13.sp,
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(EquallColors.Brand)
                .clickable { /* TODO: navigate nextEmi.ctaDeeplink */ }
                .padding(horizontal = 16.dp, vertical = 10.dp),
        ) {
            Text(
                text = nextEmi.ctaText,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
private fun DetailsCard(rows: List<LoanDetailRow>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(EquallColors.Surface)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        rows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = row.label, color = EquallColors.NavInactive, fontSize = 14.sp)
                Text(
                    text = row.value,
                    color = EquallColors.PillText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}
