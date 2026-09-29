package com.aktech.equall.data.remote.dto

/** Hard-coded Review payload, mirroring the API contract, used until the backend is live. */
val reviewMock: ReviewDataDto = ReviewDataDto(
    applicationSummary = ApplicationSummaryDto(
        applicationId = "app_7h2n4q8r",
        label = "APPLICATION UNDER REVIEW",
        productType = "PERSONAL_LOAN",
        status = "IN_REVIEW",
        badge = BadgeDto(text = "In review", variant = "WARNING", showDot = true),
        amount = AmountDto(value = 300000, currency = "INR", display = "₹3,00,000"),
        subtitle = "We'll notify you at every step.",
        deeplink = "equall://applications/app_7h2n4q8r",
    ),
    applicationProgress = ApplicationProgressDto(
        title = "APPLICATION PROGRESS",
        steps = listOf(
            ProgressStepDto(
                id = "SUBMITTED",
                title = "Application submitted",
                subtitle = "We've received your application",
                status = "COMPLETED",
                timestamp = "2026-09-29T09:14:00+05:30",
                timeLabel = "Today · 9:14 am",
                badge = null,
            ),
            ProgressStepDto(
                id = "DOCUMENTS_VERIFIED",
                title = "Documents verified",
                subtitle = "KYC and bank statement checked",
                status = "COMPLETED",
                timestamp = "2026-09-29T09:32:00+05:30",
                timeLabel = "Today · 9:32 am",
                badge = null,
            ),
            ProgressStepDto(
                id = "CREDIT_ASSESSMENT",
                title = "Credit assessment",
                subtitle = "Usually takes under 30 minutes",
                status = "CURRENT",
                timestamp = "2026-09-29T09:35:00+05:30",
                timeLabel = "Started 9:35 am",
                badge = BadgeDto(text = "CURRENT", variant = "INFO", showDot = false),
            ),
            ProgressStepDto(
                id = "DISBURSAL",
                title = "Disbursal",
                subtitle = "Money sent to your bank account",
                status = "PENDING",
                timestamp = null,
                timeLabel = null,
                badge = null,
            ),
        ),
    ),
    trustIq = TrustIqDto(
        title = "TrustIQ",
        score = null,
        maxScore = 900,
        change = null,
        message = "Score updates after decision",
        band = "EXCELLENT",
        bandLabel = "EXCELLENT",
        lastUpdatedAt = "2026-09-01T00:00:00+05:30",
        deeplink = "equall://trustiq",
    ),
)
