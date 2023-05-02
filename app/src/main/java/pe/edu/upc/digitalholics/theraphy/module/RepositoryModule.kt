package pe.edu.upc.digitalholics.theraphy.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.digitalholics.theraphy.repository.PatientRepository
import pe.edu.upc.digitalholics.theraphy.repository.PatientRepositoryImpl
import pe.edu.upc.digitalholics.theraphy.repository.PhysiotherapistRepository
import pe.edu.upc.digitalholics.theraphy.repository.PhysiotherapistRepositoryImpl
import pe.edu.upc.digitalholics.theraphy.repository.ReviewRepository
import pe.edu.upc.digitalholics.theraphy.repository.ReviewRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun providePatientRepository(impl: PatientRepositoryImpl): PatientRepository

    @Binds
    fun providePhysiotherapistRepository(impl: PhysiotherapistRepositoryImpl): PhysiotherapistRepository

    @Binds
    fun provideReviewRepository(impl: ReviewRepositoryImpl): ReviewRepository
}