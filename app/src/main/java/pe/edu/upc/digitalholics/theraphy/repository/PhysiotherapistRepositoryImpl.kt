package pe.edu.upc.digitalholics.theraphy.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.digitalholics.theraphy.data.local.PhysiotherapistDao
import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist
import pe.edu.upc.digitalholics.theraphy.data.remote.PhysiotherapistService
import pe.edu.upc.digitalholics.theraphy.resource.Resource
import javax.inject.Inject

class PhysiotherapistRepositoryImpl @Inject constructor(
    private val physiotherapistService: PhysiotherapistService,
    private val physiotherapistDao: PhysiotherapistDao
): PhysiotherapistRepository {
    override suspend fun update(physiotherapist: Physiotherapist) = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPhysiotherapistBySpecialization(specialization: String): Resource<List<Physiotherapist>> = withContext(Dispatchers.IO) {
        val response = physiotherapistService.fetchPhysiotherapistBySpecialization(specialization)
        val physiotherapists: List<Physiotherapist>
        if (response.body()!!.response == "success"){
            if (response.body()!!.response == "success"){
                physiotherapists = response.body()!!.resultPhysiotherapist
                for (physiotherapist in physiotherapists){
                    update(physiotherapist)
                }
                return@withContext Resource.Success(physiotherapists)
            }
        }
        return@withContext Resource.Error("No data found")
    }

    override suspend fun fetchReviewsPhysiotherapistById(id: String): Resource<Physiotherapist> = withContext(Dispatchers.IO){
        val response = physiotherapistService.fetchReviewsPhysiotherapistById(id)
        val physiotherapist = response.body() as Physiotherapist
        update(physiotherapist)
        return@withContext Resource.Success(physiotherapist)
    }

    override suspend fun delete(physiotherapist: Physiotherapist) = withContext(Dispatchers.IO) {
        physiotherapistDao.delete(physiotherapist)
    }

    override suspend fun insert(physiotherapist: Physiotherapist) = withContext(Dispatchers.IO) {
        physiotherapistDao.insert(physiotherapist)
    }
}