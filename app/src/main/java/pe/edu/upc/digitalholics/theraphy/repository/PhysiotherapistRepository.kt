package pe.edu.upc.digitalholics.theraphy.repository

import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist
import pe.edu.upc.digitalholics.theraphy.resource.Resource

interface PhysiotherapistRepository {

    suspend fun update(physiotherapist: Physiotherapist)
    suspend fun fetchPhysiotherapistBySpecialization(specialization: String): Resource<List<Physiotherapist>>
    suspend fun fetchReviewsPhysiotherapistById(id: String): Resource<Physiotherapist>
    suspend fun delete(physiotherapist: Physiotherapist)
    suspend fun insert(physiotherapist: Physiotherapist)

}