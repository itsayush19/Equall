package com.aktech.equall.data.mapper

import com.aktech.equall.data.remote.dto.TrustIqDto
import com.aktech.equall.domain.model.TrustIq

/** Shared mapping for the TrustIQ card, reused by the Discovery, Review and Active mappers. */
class TrustIqMapper {
    fun map(dto: TrustIqDto): TrustIq = TrustIq(
        title = dto.title,
        score = dto.score,
        changeDisplay = dto.change?.display,
        isPositiveChange = dto.change?.direction?.equals("UP", ignoreCase = true) == true,
        message = dto.message,
        bandLabel = dto.bandLabel,
    )
}
