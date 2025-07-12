package dev.yelinaung.dosetime.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.yelinaung.dosetime.core.database.DoseDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun providesDoseDatabase(
        @ApplicationContext context: Context,
    ): DoseDatabase = Room.databaseBuilder(
        context,
        DoseDatabase::class.java,
        "dose-database",
    ).build()

}