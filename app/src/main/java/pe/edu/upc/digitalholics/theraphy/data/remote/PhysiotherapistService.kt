package pe.edu.upc.digitalholics.theraphy.data.remote

import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhysiotherapistService {

    @GET("physiotherapist/{specialization}")
    suspend fun fetchPhysiotherapistBySpecialization(@Path("specialization") specialization: String): Response<ApiResponse>

    @GET("physiotherapist/{physiotherapistId}/reviews")
    suspend fun fetchReviewsPhysiotherapistById(@Path("physiotherapistId") physiotherapistId: String): Response<Physiotherapist>

}