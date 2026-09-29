package com.aktech.equall.data.repository

import com.aktech.equall.domain.model.ReviewInfo

interface ReviewRepository {
    suspend fun getReview(): ReviewInfo
}
