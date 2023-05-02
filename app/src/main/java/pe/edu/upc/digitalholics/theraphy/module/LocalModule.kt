package pe.edu.upc.digitalholics.theraphy.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.digitalholics.theraphy.data.local.AppDatabase
import pe.edu.upc.digitalholics.theraphy.data.local.PatientDao
import pe.edu.upc.digitalholics.theraphy.data.local.PhysiotherapistDao
import pe.edu.upc.digitalholics.theraphy.data.local.ReviewDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase{
        return Room.databaseBuilder(application, AppDatabase::class.java, "theraphydb").build()
    }

    @Provides
    @Singleton
    fun providePatientDao(appDatabase: AppDatabase): PatientDao{
        return appDatabase.patientDao()
    }

    @Provides
    @Singleton
    fun providePhysiotherapistDao(appDatabase: AppDatabase): PhysiotherapistDao{
        return appDatabase.physiotherapistDao()
    }

    @Provides
    @Singleton
    fun provideReviewDao(appDatabase: AppDatabase): ReviewDao{
        return appDatabase.reviewDao()
    }

}