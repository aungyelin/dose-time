package dev.yelinaung.dosetime.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.yelinaung.dosetime.core.data.repoimpl.UserDataRepositoryImpl
import dev.yelinaung.dosetime.core.domain.repository.UserDataRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepository: UserDataRepositoryImpl
    ): UserDataRepository

}