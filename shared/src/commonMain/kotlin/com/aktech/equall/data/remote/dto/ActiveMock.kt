package com.aktech.equall.data.remote.dto

/** Hard-coded Active loan payload, mirroring the API contract, used until the backend is live. */
val activeMock: ActiveDataDto = ActiveDataDto(
    loanSummary = LoanSummaryDto(
        loanId = "loan_3k9p2w7z",
        label = "OUTSTANDING",
        productType = "PERSONAL_LOAN",
        status = "ACTIVE",
        badge = BadgeDto(text = "12-month loan", variant = "NEUTRAL", showDot = false),
        outstanding = AmountDto(value = 245000, currency = "INR", display = "₹2,45,000"),
        emiProgress = EmiProgressDto(
            paid = 4,
            total = 12,
            remaining = 8,
            paidLabel = "4 of 12 EMIs paid",
            remainingLabel = "8 left",
        ),
        deeplink = "equall://loans/loan_3k9p2w7z",
    ),
    nextEmi = NextEmiDto(
        title = "Next EMI due in 3 days",
        subtitle = "₹12,450 will be autodebited",
        dueDate = "2026-10-05",
        daysLeft = 3,
        amount = AmountDto(value = 12450, currency = "INR", display = "₹12,450"),
        isAutodebitEnabled = true,
        variant = "WARNING",
        cta = CtaDto(
            text = "Pay now",
            action = "NAVIGATE",
            deeplink = "equall://payments/emi?loanId=loan_3k9p2w7z",
        ),
    ),
    loanDetails = LoanDetailsDto(
        rows = listOf(
            LoanDetailRowDto(id = "APR", label = "APR", value = "14.5%"),
            LoanDetailRowDto(id = "EMI_AMOUNT", label = "EMI amount", value = "₹12,450"),
            LoanDetailRowDto(id = "DUE_DATE", label = "Due date", value = "5th of every month"),
            LoanDetailRowDto(id = "AUTODEBIT", label = "Autodebit", value = "HDFC Bank ••4521"),
        ),
    ),
    trustIq = TrustIqDto(
        title = "TrustIQ",
        score = 812,
        maxScore = 900,
        change = TrustIqChangeDto(value = 12, direction = "UP", period = "MONTH", display = "+12 this month"),
        message = null,
        band = "EXCELLENT",
        bandLabel = "EXCELLENT",
        lastUpdatedAt = "2026-09-01T00:00:00+05:30",
        deeplink = "equall://trustiq",
    ),
)
