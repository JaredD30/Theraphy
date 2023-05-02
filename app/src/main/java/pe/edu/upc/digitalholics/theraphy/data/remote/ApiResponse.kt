package pe.edu.upc.digitalholics.theraphy.data.remote

import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist
import pe.edu.upc.digitalholics.theraphy.data.model.Review

class ApiResponse(
    val response: String,
    val resultReview: List<Review>,
    val resultPatient: List<Patient>,
    val resultPhysiotherapist: List<Physiotherapist>
)