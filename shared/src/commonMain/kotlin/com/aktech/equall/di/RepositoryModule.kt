package com.aktech.equall.di

import com.aktech.equall.data.repository.ActiveRepository
import com.aktech.equall.data.repository.ActiveRepositoryImpl
import com.aktech.equall.data.repository.DiscoveryRepository
import com.aktech.equall.data.repository.DiscoveryRepositoryImpl
import com.aktech.equall.data.repository.ReviewRepository
import com.aktech.equall.data.repository.ReviewRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<DiscoveryRepository> { DiscoveryRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
    single<ActiveRepository> { ActiveRepositoryImpl(get(), get()) }
}
