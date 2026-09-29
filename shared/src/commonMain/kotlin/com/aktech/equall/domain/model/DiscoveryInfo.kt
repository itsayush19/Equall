package com.aktech.equall.domain.model

data class DiscoveryInfo(
    val greeting: String,
    val userName: String,
    val offer: PreQualifiedOffer,
    val trustIq: TrustIq,
    val exploreTitle: String,
    val exploreProducts: List<ExploreProduct>,
)

data class PreQualifiedOffer(
    val label: String,
    val productTag: String,
    val amountDisplay: String,
    val subtitle: String,
    val ctaText: String,
    val ctaDeeplink: String,
)

data class ExploreProduct(
    val iconText: String,
    val title: String,
    val subtitle: String?,
    val badgeText: String?,
    val isAvailable: Boolean,
    val deeplink: String?,
)
