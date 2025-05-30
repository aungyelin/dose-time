package dev.yelinaung.dosetime.core.common.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @DoseDispatcher(DoseDispatchers.Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @DoseDispatcher(DoseDispatchers.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

}
