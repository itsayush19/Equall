package com.aktech.equall.data.repository

import com.aktech.equall.domain.model.HomeData

interface HomeRepository {
    suspend fun getHome(): HomeData
}
