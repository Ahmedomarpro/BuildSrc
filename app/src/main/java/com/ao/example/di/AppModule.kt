package com.ao.example.di

import com.ao.example.presentation.utils.ResourcesResolver
import com.ao.example.presentation.utils.ResourcesResolverImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun provideResourcesResolver(
        resourcesResolverImpl: ResourcesResolverImpl
    ): ResourcesResolver

}