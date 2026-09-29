package com.aktech.equall.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ActiveDataDto(
    val loanSummary: LoanSummaryDto,
    val nextEmi: NextEmiDto,
    val loanDetails: LoanDetailsDto,
    val trustIq: TrustIqDto,
)

@Serializable
data class LoanSummaryDto(
    val loanId: String,
    val label: String,
    val productType: String,
    val status: String,
    val badge: BadgeDto,
    val outstanding: AmountDto,
    val emiProgress: EmiProgressDto,
    val deeplink: String,
)

@Serializable
data class EmiProgressDto(
    val paid: Int,
    val total: Int,
    val remaining: Int,
    val paidLabel: String,
    val remainingLabel: String,
)

@Serializable
data class NextEmiDto(
    val title: String,
    val subtitle: String,
    val dueDate: String,
    val daysLeft: Int,
    val amount: AmountDto,
    val isAutodebitEnabled: Boolean,
    val variant: String,
    val cta: CtaDto,
)

@Serializable
data class LoanDetailsDto(
    val rows: List<LoanDetailRowDto>,
)

@Serializable
data class LoanDetailRowDto(
    val id: String,
    val label: String,
    val value: String,
)
