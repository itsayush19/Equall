package com.aktech.equall.di

import com.aktech.equall.data.mapper.ActiveMapper
import com.aktech.equall.data.mapper.DiscoveryMapper
import com.aktech.equall.data.mapper.ReviewMapper
import com.aktech.equall.data.mapper.TrustIqMapper
import org.koin.dsl.module

val mapperModule = module {
    single { TrustIqMapper() }
    single { DiscoveryMapper(get()) }
    single { ReviewMapper(get()) }
    single { ActiveMapper(get()) }
}
