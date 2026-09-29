package com.aktech.equall.data.repository

import com.aktech.equall.data.mapper.HomeMapper
import com.aktech.equall.data.remote.dto.homeMock
import com.aktech.equall.domain.model.HomeData
import io.ktor.client.HttpClient

class HomeRepositoryImpl(
    private val client: HttpClient,
    private val mapper: HomeMapper,
) : HomeRepository {
    // TODO: replace the mock with the real call once the backend is live:
    //   mapper.map(client.get(ApiRoutes.HOME).body())
    override suspend fun getHome(): HomeData = mapper.map(homeMock)
}
