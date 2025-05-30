package dev.yelinaung.dosetime.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.yelinaung.dosetime.core.common.coroutine.DoseCoroutineScope
import dev.yelinaung.dosetime.core.common.coroutine.DoseDispatcher
import dev.yelinaung.dosetime.core.common.coroutine.DoseDispatchers
import dev.yelinaung.dosetime.core.datastore.UserPreferences
import dev.yelinaung.dosetime.core.datastore.UserPreferencesSerializer
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
        @DoseDispatcher(DoseDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        @DoseCoroutineScope scope: CoroutineScope,
        userPreferencesSerializer: UserPreferencesSerializer,
    ): DataStore<UserPreferences> {
        return DataStoreFactory.create(
            serializer = userPreferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
        ) {
            context.dataStoreFile("user_preferences.pb")
        }
    }

}