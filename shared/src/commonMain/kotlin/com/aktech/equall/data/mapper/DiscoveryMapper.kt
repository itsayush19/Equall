package com.aktech.equall.data.mapper

import com.aktech.equall.data.remote.dto.DiscoveryDataDto
import com.aktech.equall.data.remote.dto.ExploreProductDto
import com.aktech.equall.data.remote.dto.PreQualifiedOfferDto
import com.aktech.equall.domain.model.DiscoveryInfo
import com.aktech.equall.domain.model.ExploreProduct
import com.aktech.equall.domain.model.PreQualifiedOffer

class DiscoveryMapper(
    private val trustIqMapper: TrustIqMapper,
) {
    fun map(dto: DiscoveryDataDto): DiscoveryInfo = DiscoveryInfo(
        // Greeting + user name aren't part of the API payload yet, so hard-code them here.
        greeting = "Good morning",
        userName = "Hi, Priya",
        offer = dto.preQualifiedOffer.toDomain(),
        trustIq = trustIqMapper.map(dto.trustIq),
        exploreTitle = dto.explore.title,
        exploreProducts = dto.explore.products.map { it.toDomain() },
    )

    private fun PreQualifiedOfferDto.toDomain() = PreQualifiedOffer(
        label = label,
        productTag = productTag,
        amountDisplay = amount.display,
        subtitle = subtitle,
        ctaText = cta.text,
        ctaDeeplink = cta.deeplink,
    )

    private fun ExploreProductDto.toDomain() = ExploreProduct(
        iconText = iconText,
        title = title,
        subtitle = subtitle,
        badgeText = badge?.text,
        isAvailable = status.equals("AVAILABLE", ignoreCase = true),
        deeplink = deeplink,
    )
}
