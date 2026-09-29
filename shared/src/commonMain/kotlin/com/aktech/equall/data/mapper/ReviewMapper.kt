package com.aktech.equall.data.mapper

import com.aktech.equall.data.remote.dto.ApplicationSummaryDto
import com.aktech.equall.data.remote.dto.ProgressStepDto
import com.aktech.equall.data.remote.dto.ReviewDataDto
import com.aktech.equall.domain.model.ApplicationSummary
import com.aktech.equall.domain.model.ReviewInfo
import com.aktech.equall.domain.model.ReviewStepInfo
import com.aktech.equall.domain.model.ReviewStepState

class ReviewMapper(
    private val trustIqMapper: TrustIqMapper,
) {
    fun map(dto: ReviewDataDto): ReviewInfo = ReviewInfo(
        // Greeting + user name aren't part of the API payload yet, so hard-code them here.
        greeting = "Good morning",
        userName = "Hi, Priya",
        summary = dto.applicationSummary.toDomain(),
        progressTitle = dto.applicationProgress.title,
        steps = dto.applicationProgress.steps.map { it.toDomain() },
        trustIq = trustIqMapper.map(dto.trustIq),
    )

    private fun ApplicationSummaryDto.toDomain() = ApplicationSummary(
        label = label,
        badgeText = badge.text,
        showBadgeDot = badge.showDot,
        amountDisplay = amount.display,
        subtitle = subtitle,
    )

    private fun ProgressStepDto.toDomain() = ReviewStepInfo(
        title = title,
        subtitle = subtitle,
        timeLabel = timeLabel,
        badgeText = badge?.text,
        state = when (status.uppercase()) {
            "COMPLETED" -> ReviewStepState.DONE
            "CURRENT" -> ReviewStepState.CURRENT
            else -> ReviewStepState.PENDING
        },
    )
}
