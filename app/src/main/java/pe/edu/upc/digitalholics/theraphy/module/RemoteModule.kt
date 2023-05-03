package pe.edu.upc.digitalholics.theraphy.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.digitalholics.theraphy.data.remote.PatientService
import pe.edu.upc.digitalholics.theraphy.data.remote.PhysiotherapistService
import pe.edu.upc.digitalholics.theraphy.data.remote.ReviewService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    @Named("url")
    fun provideApiBaseUrl(): String{
        return "backendproyectotheraphy-production.up.railway.app/api/v1/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("url") apiBaseUrl: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePatientService(retrofit: Retrofit): PatientService {
        return retrofit.create(PatientService::class.java)
    }

    @Provides
    @Singleton
    fun providePhysiotherapistService(retrofit: Retrofit): PhysiotherapistService {
        return retrofit.create(PhysiotherapistService::class.java)
    }

    @Provides
    @Singleton
    fun provideReviewService(retrofit: Retrofit): ReviewService{
        return retrofit.create(ReviewService::class.java)
    }
}