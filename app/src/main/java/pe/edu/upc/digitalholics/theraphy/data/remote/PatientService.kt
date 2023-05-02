package pe.edu.upc.digitalholics.theraphy.data.remote

import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PatientService {

    @GET("patient/{name}")
    suspend fun fetchPatientByName(@Path("name") name: String): Response<ApiResponse>

    @GET("patients/{patientsId}/reviews")
    suspend fun fetchReviewPatientById(@Path("patientsId") patientsId: String): Response<Patient>

}