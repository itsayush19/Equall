package com.aktech.equall.data.mapper

import com.aktech.equall.data.remote.dto.ActiveDataDto
import com.aktech.equall.data.remote.dto.LoanDetailRowDto
import com.aktech.equall.data.remote.dto.LoanSummaryDto
import com.aktech.equall.data.remote.dto.NextEmiDto
import com.aktech.equall.domain.model.ActiveLoan
import com.aktech.equall.domain.model.LoanDetailRow
import com.aktech.equall.domain.model.LoanSummary
import com.aktech.equall.domain.model.NextEmi

class ActiveMapper(
    private val trustIqMapper: TrustIqMapper,
) {
    fun map(dto: ActiveDataDto): ActiveLoan = ActiveLoan(
        // Greeting + user name aren't part of the API payload yet, so hard-code them here.
        greeting = "Good morning",
        userName = "Hi, Priya",
        summary = dto.loanSummary.toDomain(),
        nextEmi = dto.nextEmi.toDomain(),
        details = dto.loanDetails.rows.map { it.toDomain() },
        trustIq = trustIqMapper.map(dto.trustIq),
    )

    private fun LoanSummaryDto.toDomain() = LoanSummary(
        label = label,
        badgeText = badge.text,
        outstandingDisplay = outstanding.display,
        paid = emiProgress.paid,
        total = emiProgress.total,
        paidLabel = emiProgress.paidLabel,
        remainingLabel = emiProgress.remainingLabel,
    )

    private fun NextEmiDto.toDomain() = NextEmi(
        title = title,
        subtitle = subtitle,
        ctaText = cta.text,
        ctaDeeplink = cta.deeplink,
    )

    private fun LoanDetailRowDto.toDomain() = LoanDetailRow(
        label = label,
        value = value,
    )
}
