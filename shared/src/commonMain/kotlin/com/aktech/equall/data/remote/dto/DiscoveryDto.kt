package com.aktech.equall.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class DiscoveryDataDto(
    val preQualifiedOffer: PreQualifiedOfferDto,
    val trustIq: TrustIqDto,
    val explore: ExploreDto,
)

@Serializable
data class PreQualifiedOfferDto(
    val offerId: String,
    val label: String,
    val productType: String,
    val productTag: String,
    val amount: AmountDto,
    val maxTenureMonths: Int,
    val subtitle: String,
    val cta: CtaDto,
    val expiresAt: String,
)

@Serializable
data class ExploreDto(
    val title: String,
    val products: List<ExploreProductDto>,
)

@Serializable
data class ExploreProductDto(
    val id: String,
    val type: String,
    val iconText: String,
    val title: String,
    val subtitle: String? = null,
    val status: String,
    val badge: BadgeDto? = null,
    val deeplink: String? = null,
)
