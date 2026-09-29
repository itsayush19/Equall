package com.aktech.equall.screens.HomeScreen.presentation.discovery

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aktech.equall.common.components.GreetingHeader
import com.aktech.equall.common.components.TrustIqCard
import com.aktech.equall.domain.model.DiscoveryInfo
import com.aktech.equall.domain.model.ExploreProduct
import com.aktech.equall.domain.model.PreQualifiedOffer
import com.aktech.equall.utils.EquallColors
import com.aktech.equall.utils.ErrorView
import com.aktech.equall.utils.LoadingView
import com.aktech.equall.utils.UiState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DiscoveryScreen(viewModel: DiscoveryViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val s = state) {
        UiState.Loading -> LoadingView()
        is UiState.Error -> ErrorView(message = s.message, onRetry = viewModel::load)
        is UiState.Success -> DiscoveryContent(s.data)
    }
}

@Composable
private fun DiscoveryContent(data: DiscoveryInfo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GreetingHeader(greeting = data.greeting, userName = data.userName)
        OfferCard(data.offer)
        TrustIqCard(data.trustIq)
        ExploreSection(title = data.exploreTitle, products = data.exploreProducts)
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun OfferCard(offer: PreQualifiedOffer) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(EquallColors.OfferGreen)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = offer.label,
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.White.copy(alpha = 0.18f))
                    .padding(horizontal = 12.dp, vertical = 5.dp),
            ) {
                Text(text = offer.productTag, color = Color.White, fontSize = 12.sp)
            }
        }

        Text(
            text = offer.amountDisplay,
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = offer.subtitle,
            color = Color.White.copy(alpha = 0.85f),
            fontSize = 14.sp,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White)
                .clickable { /* TODO: navigate offer.ctaDeeplink */ }
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = offer.ctaText,
                color = EquallColors.OfferGreenText,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
private fun ExploreSection(title: String, products: List<ExploreProduct>) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            text = title,
            color = EquallColors.SubtleText,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            products.forEach { product ->
                ExploreTile(
                    product = product,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                )
            }
        }
    }
}

@Composable
private fun ExploreTile(product: ExploreProduct, modifier: Modifier = Modifier) {
    val comingSoon = !product.isAvailable
    val container = Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(EquallColors.Surface)
        .then(
            if (comingSoon) {
                Modifier.border(1.dp, EquallColors.Border, RoundedCornerShape(16.dp))
            } else {
                Modifier
            },
        )

    Column(
        modifier = modifier
            .then(container)
            .clickable(enabled = !comingSoon) { /* TODO: navigate product.deeplink */ }
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(if (comingSoon) EquallColors.IconTileMuted else EquallColors.IconTileBg),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = product.iconText,
                color = if (comingSoon) EquallColors.NavInactive else EquallColors.Brand,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            text = product.title,
            color = EquallColors.PillText,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
        )
        if (product.subtitle != null) {
            Text(
                text = product.subtitle,
                color = EquallColors.SubtleText,
                fontSize = 11.sp,
            )
        }
        if (product.badgeText != null) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(EquallColors.BadgeAmberBg)
                    .padding(horizontal = 8.dp, vertical = 3.dp),
            ) {
                Text(
                    text = product.badgeText,
                    color = EquallColors.BadgeAmberText,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}
