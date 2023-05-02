package pe.edu.upc.digitalholics.theraphy.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.repository.PatientRepository
import pe.edu.upc.digitalholics.theraphy.resource.Resource
import javax.inject.Inject

@HiltViewModel
class PatientDetailsViewModel @Inject constructor(
    private val patientRepository: PatientRepository
): ViewModel(){

    private var _patient = MutableLiveData<Patient>()
    val patient get() = _patient

    fun fetchPatientByName(name: String){
        viewModelScope.launch {
            val result = patientRepository.fetchPatientByName(name)
            if (result is Resource.Success){
           //     _patient.value = result.data!!
            }
        }
    }

}