package com.aktech.equall.data.repository

import com.aktech.equall.data.mapper.ActiveMapper
import com.aktech.equall.data.remote.dto.activeMock
import com.aktech.equall.domain.model.ActiveLoan
import io.ktor.client.HttpClient

class ActiveRepositoryImpl(
    private val client: HttpClient,
    private val mapper: ActiveMapper,
) : ActiveRepository {
    // TODO: replace the mock with the real call once the backend is live:
    //   mapper.map(client.get(ApiRoutes.ACTIVE).body())
    override suspend fun getActive(): ActiveLoan = mapper.map(activeMock)
}
