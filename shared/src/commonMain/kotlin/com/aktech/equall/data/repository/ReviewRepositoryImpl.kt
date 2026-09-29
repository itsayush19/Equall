package com.aktech.equall.data.repository

import com.aktech.equall.data.mapper.ReviewMapper
import com.aktech.equall.data.remote.dto.reviewMock
import com.aktech.equall.domain.model.ReviewInfo
import io.ktor.client.HttpClient

class ReviewRepositoryImpl(
    private val client: HttpClient,
    private val mapper: ReviewMapper,
) : ReviewRepository {
    // TODO: replace the mock with the real call once the backend is live:
    //   mapper.map(client.get(ApiRoutes.REVIEW).body())
    override suspend fun getReview(): ReviewInfo = mapper.map(reviewMock)
}
