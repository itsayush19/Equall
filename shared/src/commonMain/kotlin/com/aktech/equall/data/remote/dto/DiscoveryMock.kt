package com.aktech.equall.data.remote.dto

/** Hard-coded Discovery payload, mirroring the API contract, used until the backend is live. */
val discoveryMock: DiscoveryDataDto = DiscoveryDataDto(
    preQualifiedOffer = PreQualifiedOfferDto(
        offerId = "off_pl_500000_36",
        label = "PRE-QUALIFIED OFFER",
        productType = "PERSONAL_LOAN",
        productTag = "Personal loan",
        amount = AmountDto(value = 500000, currency = "INR", display = "₹5,00,000"),
        maxTenureMonths = 36,
        subtitle = "Tenure up to 36 months",
        cta = CtaDto(
            text = "Check eligibility",
            action = "NAVIGATE",
            deeplink = "equall://loans/personal/eligibility?offerId=off_pl_500000_36",
        ),
        expiresAt = "2026-10-29T23:59:59+05:30",
    ),
    trustIq = TrustIqDto(
        title = "TrustIQ",
        score = 812,
        maxScore = 900,
        change = TrustIqChangeDto(value = 12, direction = "UP", period = "MONTH", display = "+12 this month"),
        band = "EXCELLENT",
        bandLabel = "EXCELLENT",
        lastUpdatedAt = "2026-09-01T00:00:00+05:30",
        deeplink = "equall://trustiq",
    ),
    explore = ExploreDto(
        title = "EXPLORE",
        products = listOf(
            ExploreProductDto(
                id = "prod_personal_loan",
                type = "PERSONAL_LOAN",
                iconText = "PL",
                title = "Personal Loan",
                subtitle = "Up to ₹5L",
                status = "AVAILABLE",
                badge = null,
                deeplink = "equall://loans/personal",
            ),
            ExploreProductDto(
                id = "prod_topup_loan",
                type = "TOPUP_LOAN",
                iconText = "TU",
                title = "Top-up Loan",
                subtitle = "For existing borrowers",
                status = "AVAILABLE",
                badge = null,
                deeplink = "equall://loans/topup",
            ),
            ExploreProductDto(
                id = "prod_credit_card",
                type = "CREDIT_CARD",
                iconText = "CC",
                title = "Credit Card",
                subtitle = null,
                status = "COMING_SOON",
                badge = BadgeDto(text = "Coming soon", variant = "WARNING"),
                deeplink = null,
            ),
        ),
    ),
)
