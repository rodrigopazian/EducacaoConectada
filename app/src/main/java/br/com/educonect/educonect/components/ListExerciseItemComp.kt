package br.com.educonect.educonect.components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.educonect.educonect.R
import br.com.educonect.educonect.database.repository.DataObjExerciseRepository
import br.com.educonect.educonect.model.DataObjExercise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListExerciseItemComp(
    listTxtExercise: List<DataObjExercise>?,
    functionUpdateList : () -> Unit,
    functionReturnIdOnClick : (Long) -> Unit
) {

    Log.i(TAG, "LISTCOMPONENT 1 - LIST ID LOG ${listTxtExercise}")

    val contextFunctionListExItemComp =  LocalContext.current


    for (exercise in listTxtExercise!!) {

        Log.i(TAG, "LISTCOMPONENT 2 - FOR - ID LOG  ${exercise}")

        Log.i(TAG, "LISTCOMPONENT 3 - FOR - ID LOG  ${exercise.id}")
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp)
                .padding(10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .defaultMinSize(minWidth = 14.dp)
                    .padding(5.dp),
                textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.purple_200),
                text = "${exercise.id}. "
            )

            Card(
                modifier = Modifier
                    .padding(10.dp, 0.dp)
                    .width(270.dp)
                    .defaultMinSize(minHeight = 100.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.purple_200)),
                onClick = {
                    functionReturnIdOnClick(exercise.id)
                }
                ) {


                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = colorResource(id = R.color.white),
                    text = "${exercise.txtexerc}"
                )

            }
            Button(
                modifier = Modifier
                    .wrapContentSize()
                    .offset(x = (-12).dp, y = (-4).dp),
                shape = RectangleShape,
                onClick = {
                    //Change to listviewmodel access to DAOREPO
                    val dataObjExerciseRepository = DataObjExerciseRepository(context = contextFunctionListExItemComp)
                    dataObjExerciseRepository.delete(DataObjExercise(id = exercise.id))
                    functionUpdateList()
                },
                border = BorderStroke(2.dp, Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0x00FFFFFF)),

                ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "Limpar texto"
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}
