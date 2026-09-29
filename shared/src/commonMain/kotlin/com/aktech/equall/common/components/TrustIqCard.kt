package com.aktech.equall.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aktech.equall.domain.model.TrustIq
import com.aktech.equall.utils.EquallColors

/** TrustIQ score card shared across the Home tabs. */
@Composable
fun TrustIqCard(
    trustIq: TrustIq,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(EquallColors.Surface)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(EquallColors.TrustIqAvatarBg),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "IQ",
                color = EquallColors.ScoreGreen,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Text(
                text = trustIq.title,
                color = EquallColors.SubtleText,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
            )
            if (trustIq.score != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = trustIq.score.toString(),
                        color = EquallColors.PillText,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    if (trustIq.changeDisplay != null) {
                        Text(
                            text = if (trustIq.isPositiveChange) "▲ ${trustIq.changeDisplay}" else trustIq.changeDisplay,
                            color = EquallColors.ScoreGreen,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
            } else if (trustIq.message != null) {
                Text(
                    text = trustIq.message,
                    color = EquallColors.PillText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(EquallColors.ScoreBadgeBg)
                .padding(horizontal = 10.dp, vertical = 6.dp),
        ) {
            Text(
                text = trustIq.bandLabel,
                color = Color.White,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
