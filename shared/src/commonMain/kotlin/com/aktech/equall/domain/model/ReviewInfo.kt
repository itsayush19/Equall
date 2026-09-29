package com.aktech.equall.domain.model

data class ReviewInfo(
    val greeting: String,
    val userName: String,
    val summary: ApplicationSummary,
    val progressTitle: String,
    val steps: List<ReviewStepInfo>,
    val trustIq: TrustIq,
)

data class ApplicationSummary(
    val label: String,
    val badgeText: String,
    val showBadgeDot: Boolean,
    val amountDisplay: String,
    val subtitle: String,
)

data class ReviewStepInfo(
    val title: String,
    val subtitle: String,
    val timeLabel: String?,
    val badgeText: String?,
    val state: ReviewStepState,
)

enum class ReviewStepState { DONE, CURRENT, PENDING }
