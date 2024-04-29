package br.com.educonect.educonect.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.educonect.educonect.R
import br.com.educonect.educonect.model.DataObjExercise

@Composable
fun ListExerciseItemComp(
    listTxtExercises: List<DataObjExercise>
) {
    for (exercise in listTxtExercises) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp)
                .padding(10.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .defaultMinSize(minWidth = 10.dp)
                    .padding(5.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.purple_200),
                text = "${exercise.id}. "
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp)
                    .defaultMinSize(minHeight = 100.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.purple_200)),

                ) {


                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = colorResource(id = R.color.white),
                    text = "${exercise.txtexerc}"
                )

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}
