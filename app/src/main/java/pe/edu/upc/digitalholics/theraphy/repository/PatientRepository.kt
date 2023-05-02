package pe.edu.upc.digitalholics.theraphy.repository

import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.resource.Resource

interface PatientRepository {

    suspend fun update(patient: Patient)
    suspend fun fetchPatientByName(name: String): Resource<List<Patient>>
    suspend fun fetchReviewPatientById(id: String): Resource<Patient>
    suspend fun delete(patient: Patient)
    suspend fun insert(patient: Patient)

}