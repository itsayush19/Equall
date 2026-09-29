package com.aktech.equall.data.mapper

import com.aktech.equall.data.remote.dto.HomeDataDto
import com.aktech.equall.domain.model.HomeData

class HomeMapper(
    private val discoveryMapper: DiscoveryMapper,
    private val reviewMapper: ReviewMapper,
    private val activeMapper: ActiveMapper,
) {
    fun map(dto: HomeDataDto): HomeData = HomeData(
        discovery = discoveryMapper.map(dto.discovery),
        review = reviewMapper.map(dto.review),
        active = activeMapper.map(dto.active),
    )
}
