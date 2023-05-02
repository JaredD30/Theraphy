package pe.edu.upc.digitalholics.theraphy.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.digitalholics.theraphy.data.local.PatientDao
import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.data.remote.PatientService
import pe.edu.upc.digitalholics.theraphy.resource.Resource
import javax.inject.Inject

class PatientRepositoryImpl @Inject constructor(
    private val patientService: PatientService,
    private val patientDao: PatientDao
): PatientRepository {
    override suspend fun update(patient: Patient) = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPatientByName(name: String): Resource<List<Patient>> =
        withContext(Dispatchers.IO) {
        val response = patientService.fetchPatientByName(name)
        val patient: List<Patient>
        if (response.isSuccessful && response.body() != null){
            if (response.body()!!.response == "success"){
                patient = response.body()!!.resultPatient
                return@withContext Resource.Success(patient)
            }
        }
            return@withContext Resource.Error("No data found")
    }

    override suspend fun fetchReviewPatientById(id: String): Resource<Patient> = withContext(Dispatchers.IO) {
        val response = patientService.fetchReviewPatientById(id)
        val patient = response.body() as Patient
        update(patient)
        return@withContext Resource.Success(patient)
    }

    override suspend fun delete(patient: Patient) = withContext(Dispatchers.IO) {
        patientDao.delete(patient)
    }

    override suspend fun insert(patient: Patient) = withContext(Dispatchers.IO) {
        patientDao.insert(patient)
    }

}