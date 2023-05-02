package pe.edu.upc.digitalholics.theraphy.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.digitalholics.theraphy.data.model.Review


@Dao
interface ReviewDao {

    @Query("select * from review where id=:id")
    suspend fun fetchReviewById(id: String): Review

    @Insert
    suspend fun insert(review: Review)

    @Delete
    suspend fun delete(review: Review)

}