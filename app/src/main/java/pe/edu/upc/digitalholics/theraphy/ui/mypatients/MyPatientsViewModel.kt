package pe.edu.upc.digitalholics.theraphy.ui.mypatients

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.repository.PatientRepository
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MyPatientsViewModel @Inject constructor(private val patientRepository: PatientRepository):
    ViewModel() {
        private var _patients = MutableLiveData<List<Patient>>()
        val patients get() = _patients
    }
