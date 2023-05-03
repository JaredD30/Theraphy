package pe.edu.upc.digitalholics.theraphy.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.digitalholics.theraphy.data.local.ReviewDao
import pe.edu.upc.digitalholics.theraphy.data.model.Review
import pe.edu.upc.digitalholics.theraphy.data.remote.ReviewService
import pe.edu.upc.digitalholics.theraphy.resource.Resource
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val reviewService: ReviewService,
    private val reviewDao: ReviewDao
): ReviewRepository {
    override suspend fun update(review: Review) = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchReviewByStarts(starts: String): Resource<List<Review>> = withContext(Dispatchers.IO) {
        val response = reviewService.fetchReviewByStarts(starts)
        val reviews: List<Review>
        if (response.isSuccessful && response.body()!=null){
            if (response.body()!!.response=="success"){
                reviews = response.body()!!.resultReview
                for (review in reviews){
                    update(review)
                }
                return@withContext Resource.Success(reviews)
            }
        }
        return@withContext Resource.Error("No data found")
    }

    override suspend fun fetchReviewById(id: String): Resource<Review> = withContext(Dispatchers.IO) {
        val response = reviewService.fetchReviewById(id)
        val review = response.body() as Review
        update(review)
        return@withContext Resource.Success(review)
    }

    override suspend fun delete(review: Review) = withContext(Dispatchers.IO) {
        reviewDao.delete(review)
    }

    override suspend fun insert(review: Review) = withContext(Dispatchers.IO) {
        reviewDao.insert(review)
    }
}