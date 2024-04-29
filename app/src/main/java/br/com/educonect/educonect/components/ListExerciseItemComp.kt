package br.com.educonect.educonect.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import br.com.educonect.educonect.R
import br.com.educonect.educonect.model.DataObjExercise

@Composable
fun ListExerciseItemComp(
    listTxtExercises: List<DataObjExercise>
){

    var list = listTxtExercises
    for (exercise in list) {
       Row {
            Text(
                color = colorResource(id = R.color.purple_200),
                text = "${exercise.id}. "
            )

            Text(
                color = colorResource(id = R.color.purple_200),
                text = "${exercise.txtexerc}"
            )

        }
    }
}
