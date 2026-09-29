package com.aktech.equall.data.repository

import com.aktech.equall.domain.model.DiscoveryInfo

interface DiscoveryRepository {
    suspend fun getDiscovery(): DiscoveryInfo
}
