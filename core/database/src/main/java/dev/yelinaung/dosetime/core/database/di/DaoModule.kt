package dev.yelinaung.dosetime.core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.yelinaung.dosetime.core.database.DoseDatabase
import dev.yelinaung.dosetime.core.database.dao.MedicationDao

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providesMedicationDao(
        database: DoseDatabase,
    ): MedicationDao = database.medicationDao()

}
