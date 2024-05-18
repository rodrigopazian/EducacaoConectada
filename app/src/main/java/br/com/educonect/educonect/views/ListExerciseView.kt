package br.com.educonect.educonect.views

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.educonect.educonect.R
import br.com.educonect.educonect.components.ListExerciseItemComp
import br.com.educonect.educonect.database.repository.DataObjExerciseRepository

@Composable
fun ListExerciseView(
    listExerciseViewModel: ListExerciseViewModel,
    navController: NavController,
    msgExController: String
) {

    //Start - Var Val Declarations
    val contextFunctionListExView = LocalContext.current
    val dataObjExerciseRepository = DataObjExerciseRepository(contextFunctionListExView)

    //var idTxtExercise by remember { mutableStateOf("") }
    val listTxtExercise by listExerciseViewModel.listTxtExercise.observeAsState(
        initial = listExerciseViewModel.listTxtExerciseVM(
            dataObjExerciseRepository
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colorResource(id = R.color.background))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .defaultMinSize(minHeight = 660.dp)
                .background(color = colorResource(id = R.color.background)),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {


            Spacer(modifier = Modifier.height(60.dp))


            Text(
                text = "Lista de Exercícios",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.purple_200)
            )

            Spacer(modifier = Modifier.height(60.dp))

            Column {
                ListExerciseItemComp(
                    listTxtExercise,
                    functionUpdateList = {
                        listExerciseViewModel.listTxtExerciseVM(dataObjExerciseRepository)
                    },
                    functionReturnIdOnClick= {
                        Log.i(ContentValues.TAG, "LIST EXERCISE VIEW 1 - ID LOG LONG ${it}")
                        navController.navigate("editexercise?id=$it")
                    },
                )
            }

            Text(
                text = "$msgExController",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.purple_200)
            )
            Button(
                onClick = {
                    navController.navigate("inputExercise")
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_200)),
            ) {
                Text(
                    text = "Adicionar Exercício",
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}