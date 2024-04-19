package br.com.educonect.educonect.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.educonect.educonect.R
import br.com.educonect.educonect.views.ListExerciseViewModel

@Composable
fun ListExerciseItemComp(listExerciseViewModel: ListExerciseViewModel) {

    var listExercises = listExerciseViewModel.onClickBtnExList

    for (exercise in listExercises) {
       Row {
            Text(
                text = "${exercise}. "
            )

            Text(
                text = "${listExercises}"
            )

           //Button - Start
           Button(
               modifier = Modifier
                   .wrapContentSize()
                   .offset(x = (-12).dp, y = (-4).dp),
               shape = RectangleShape,
               onClick = btnClearonClickIar,
               border = BorderStroke(2.dp, Color.Transparent),
               colors = ButtonDefaults.buttonColors(containerColor = Color(0x00FFFFFF)),

               ) {
               Icon(
                   modifier = Modifier
                       .size(16.dp),
                   painter = painterResource(id = R.drawable.baseline_delete_24),
                   contentDescription = "Limpar texto"
               )
           }
           //Button - End


        }
    }
}
