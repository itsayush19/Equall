package com.aktech.equall.data.remote.dto

import kotlinx.serialization.Serializable

/** Single Home payload returning every tab's data in one response. */
@Serializable
data class HomeDataDto(
    val discovery: DiscoveryDataDto,
    val review: ReviewDataDto,
    val active: ActiveDataDto,
)
