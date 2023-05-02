package pe.edu.upc.digitalholics.theraphy.data.remote

import pe.edu.upc.digitalholics.theraphy.data.model.Review
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewService {

    @GET("review/{starts}")
    suspend fun fetchReviewByStarts(@Path("starts") starts: String): Response<ApiResponse>

    @GET("{reviewId}")
    suspend fun fetchReviewById(@Path("reviewId") id: String): Response<Review>

}