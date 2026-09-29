package com.aktech.equall.data.repository

import com.aktech.equall.data.mapper.DiscoveryMapper
import com.aktech.equall.data.remote.dto.discoveryMock
import com.aktech.equall.domain.model.DiscoveryInfo
import io.ktor.client.HttpClient

class DiscoveryRepositoryImpl(
    private val client: HttpClient,
    private val mapper: DiscoveryMapper,
) : DiscoveryRepository {
    // TODO: replace the mock with the real call once the backend is live:
    //   mapper.map(client.get(ApiRoutes.DISCOVERY).body())
    override suspend fun getDiscovery(): DiscoveryInfo = mapper.map(discoveryMock)
}
