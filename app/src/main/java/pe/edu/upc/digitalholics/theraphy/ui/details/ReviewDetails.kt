package pe.edu.upc.digitalholics.theraphy.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.upc.digitalholics.theraphy.data.model.Review

@Composable
fun ReviewDetails(viewModel: ReviewDetailsViewModel){
    val review by viewModel.review.observeAsState(Review())
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(128.dp))
        review.physiotherapist.photoUrl
    }
}

@Composable
fun ReviewHeader(review: Review){
    Text(
        text = review.physiotherapist.firstName
    )
}
