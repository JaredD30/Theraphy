package pe.edu.upc.digitalholics.theraphy.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.digitalholics.theraphy.data.model.Review
import pe.edu.upc.digitalholics.theraphy.repository.ReviewRepository
import pe.edu.upc.digitalholics.theraphy.resource.Resource
import javax.inject.Inject

@HiltViewModel
class ReviewDetailsViewModel @Inject constructor(
    private val reviewRepository: ReviewRepository
): ViewModel(){

    private var _review = MutableLiveData<Review>()
    val review get() = _review

    fun fetchReviewById(id: String){
        viewModelScope.launch {
            val result = reviewRepository.fetchReviewById(id)
            if (result is Resource.Success){
                _review.value = result.data!!
            }
        }
    }

}