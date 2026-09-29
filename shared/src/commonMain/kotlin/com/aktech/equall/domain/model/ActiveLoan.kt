package com.aktech.equall.domain.model

/** Domain model for the Active loan tab. */
data class ActiveLoan(
    val greeting: String,
    val userName: String,
    val summary: LoanSummary,
    val nextEmi: NextEmi,
    val details: List<LoanDetailRow>,
    val trustIq: TrustIq,
)

data class LoanSummary(
    val label: String,
    val badgeText: String,
    val outstandingDisplay: String,
    val paid: Int,
    val total: Int,
    val paidLabel: String,
    val remainingLabel: String,
)

data class NextEmi(
    val title: String,
    val subtitle: String,
    val ctaText: String,
    val ctaDeeplink: String,
)

data class LoanDetailRow(
    val label: String,
    val value: String,
)
