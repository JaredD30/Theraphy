package pe.edu.upc.digitalholics.theraphy.repository

import pe.edu.upc.digitalholics.theraphy.data.model.Review
import pe.edu.upc.digitalholics.theraphy.resource.Resource

interface ReviewRepository {

    suspend fun update(review: Review)
    suspend fun fetchReviewByStarts(starts: String): Resource<List<Review>>
    suspend fun fetchReviewById(id: String): Resource<Review>
    suspend fun delete(review: Review)
    suspend fun insert(review: Review)

}