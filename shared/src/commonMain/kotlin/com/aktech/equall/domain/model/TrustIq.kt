package com.aktech.equall.domain.model

/**
 * TrustIQ card model, shared across tabs. When [score] is null the card shows
 * [message] instead of the number + change (e.g. "Score updates after decision").
 */
data class TrustIq(
    val title: String,
    val score: Int?,
    val changeDisplay: String?,
    val isPositiveChange: Boolean,
    val message: String?,
    val bandLabel: String,
)
