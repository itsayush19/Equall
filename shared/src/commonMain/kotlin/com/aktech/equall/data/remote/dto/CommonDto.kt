package com.aktech.equall.data.remote.dto

import kotlinx.serialization.Serializable

/** DTOs shared across multiple Home tabs. */

@Serializable
data class AmountDto(
    val value: Long,
    val currency: String,
    val display: String,
)

@Serializable
data class BadgeDto(
    val text: String,
    val variant: String,
    val showDot: Boolean = false,
)

@Serializable
data class CtaDto(
    val text: String,
    val action: String,
    val deeplink: String,
)

@Serializable
data class TrustIqDto(
    val title: String,
    val score: Int? = null,
    val maxScore: Int,
    val change: TrustIqChangeDto? = null,
    val message: String? = null,
    val band: String,
    val bandLabel: String,
    val lastUpdatedAt: String,
    val deeplink: String,
)

@Serializable
data class TrustIqChangeDto(
    val value: Int,
    val direction: String,
    val period: String,
    val display: String,
)
