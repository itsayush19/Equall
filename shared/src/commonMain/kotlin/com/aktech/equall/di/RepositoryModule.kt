package com.aktech.equall.di

import com.aktech.equall.data.repository.HomeRepository
import com.aktech.equall.data.repository.HomeRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}
