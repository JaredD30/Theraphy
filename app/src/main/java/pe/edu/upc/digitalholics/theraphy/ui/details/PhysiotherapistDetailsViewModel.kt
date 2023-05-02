package pe.edu.upc.digitalholics.theraphy.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist
import pe.edu.upc.digitalholics.theraphy.repository.PhysiotherapistRepository
import pe.edu.upc.digitalholics.theraphy.resource.Resource
import javax.inject.Inject

@HiltViewModel
class PhysiotherapistDetailsViewModel @Inject constructor(
    private val physiotherapistRepository: PhysiotherapistRepository
): ViewModel(){

    private var _physiotherapist = MutableLiveData<Physiotherapist>()
    val physiotherapist get() = _physiotherapist

    fun fetchReviewsPhysiotherapistById(id: String){
        viewModelScope.launch{
            val result = physiotherapistRepository.fetchReviewsPhysiotherapistById(id)
            if (result is Resource.Success){
                _physiotherapist.value = result.data!!
            }
        }
    }

}