package pe.edu.upc.digitalholics.theraphy.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.digitalholics.theraphy.data.model.Patient

@Dao
interface PatientDao {

    @Query("select * from patient where id=:id")
    suspend fun fetchPatientById(id: String): Patient?

    @Insert
    suspend fun insert(patient: Patient)

    @Delete
    suspend fun delete(patient: Patient)
}