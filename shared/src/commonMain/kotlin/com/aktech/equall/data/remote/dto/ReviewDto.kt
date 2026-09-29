package com.aktech.equall.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReviewDataDto(
    val applicationSummary: ApplicationSummaryDto,
    val applicationProgress: ApplicationProgressDto,
    val trustIq: TrustIqDto,
)

@Serializable
data class ApplicationSummaryDto(
    val applicationId: String,
    val label: String,
    val productType: String,
    val status: String,
    val badge: BadgeDto,
    val amount: AmountDto,
    val subtitle: String,
    val deeplink: String,
)

@Serializable
data class ApplicationProgressDto(
    val title: String,
    val steps: List<ProgressStepDto>,
)

@Serializable
data class ProgressStepDto(
    val id: String,
    val title: String,
    val subtitle: String,
    val status: String, // COMPLETED | CURRENT | PENDING
    val timestamp: String? = null,
    val timeLabel: String? = null,
    val badge: BadgeDto? = null,
)
