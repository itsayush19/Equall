package com.aktech.equall.domain.model

/** All Home tab data fetched in a single call. */
data class HomeData(
    val discovery: DiscoveryInfo,
    val review: ReviewInfo,
    val active: ActiveLoan,
)
