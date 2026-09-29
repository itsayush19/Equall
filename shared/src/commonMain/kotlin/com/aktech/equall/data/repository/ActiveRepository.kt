package com.aktech.equall.data.repository

import com.aktech.equall.domain.model.ActiveLoan

interface ActiveRepository {
    suspend fun getActive(): ActiveLoan
}
