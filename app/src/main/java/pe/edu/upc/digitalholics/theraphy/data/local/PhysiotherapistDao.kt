package pe.edu.upc.digitalholics.theraphy.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist


@Dao
interface PhysiotherapistDao {

    @Query("select * from physiotherapist where id=:id")
    suspend fun fetchPhysiotherapistById(id: String): Physiotherapist?

    @Insert
    suspend fun insert(physiotherapist: Physiotherapist)

    @Delete
    suspend fun delete(physiotherapist: Physiotherapist)
}