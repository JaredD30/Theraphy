package pe.edu.upc.digitalholics.theraphy.ui.mypatients

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.ui.details.PatientDetailsViewModel
import pe.edu.upc.digitalholics.theraphy.ui.navigation.Routes



@Composable
fun MyPatients(viewModel: MyPatientsViewModel = hiltViewModel()) {
    MyPatientsList(viewModel)
}


@Composable
fun MyPatientsList(
    viewModel: MyPatientsViewModel
) {
    val patients: List<Patient> by viewModel.patients.observeAsState(listOf())

    LazyColumn{
        items(patients) { patient ->
            PatientRow(patient)
        }
    }
}

@Composable
fun PatientRow(
    patient: Patient
){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier.clickable {}) {
            PatientImage(patient)
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(7f)) {
                Text(patient.firstName, fontWeight = FontWeight.Bold)
            }

            IconButton(modifier = Modifier.weight(1f),
                onClick = {

                }) {
            }
        }
    }
}

@Composable
fun PatientImage(patient: Patient) {
    Image(painter = rememberImagePainter(patient.photoUrl), contentDescription = null,
        modifier = Modifier
            .size(92.dp)
            .clip(shape = RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop
        )
}