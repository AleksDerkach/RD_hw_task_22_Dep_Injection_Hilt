package com.example.task_21_hometask_depinj_hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AplicationModule {
    @Provides
    @Singleton
    fun getApiClient() = ApiClient()
    @Provides
    @Singleton
    fun getRepository(apiclientHilt: ApiClient) = Repository(apiclientHilt)
}