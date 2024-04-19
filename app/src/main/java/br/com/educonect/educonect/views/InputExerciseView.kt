package br.com.educonect.educonect.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.educonect.educonect.R
import br.com.educonect.educonect.components.InputAnswerRow
import br.com.educonect.educonect.components.InputTextField
import br.com.educonect.educonect.database.repository.DataObjExerciseRepository
import br.com.educonect.educonect.model.DataObjExercise


//--------------------------------------------------------------------------------------------------------------------------------------


//Annotation - Composable Function MyComponent
@Composable
//Start - Function MyComponent
fun InputExerciseView(
    inputExerciseViewModel: InputExerciseViewModel,
    navController: NavController
) {

    //Start - Var Val Declarations

    //var textoExercicio by remember { mutableStateOf("") }
    val textoExercicio by inputExerciseViewModel.textoExercicio.observeAsState(initial = "")

    //var textoA by remember { mutableStateOf("") }
    val textoA by inputExerciseViewModel.textoA.observeAsState(initial = "")

    //var textoB by remember { mutableStateOf("") }
    val textoB by inputExerciseViewModel.textoB.observeAsState(initial = "")

    //var textoC by remember { mutableStateOf("") }
    val textoC by inputExerciseViewModel.textoC.observeAsState(initial = "")

    //var textoD by remember { mutableStateOf("") }
    val textoD by inputExerciseViewModel.textoD.observeAsState(initial = "")

    //var textoE by remember { mutableStateOf("") }
    val textoE by inputExerciseViewModel.textoE.observeAsState(initial = "")

    var altSelectd by remember {
        mutableStateOf("")
    }

    //Obtain Context
    val context = LocalContext.current
    val dataObjExerciseRepository = DataObjExerciseRepository(context)

    //End - Var Val Declarations


//--------------------------------------------------------------------------------------------------------------------------------------


    //Start - Main Column (that is a type of a container)
    //modifier argument - Is passing an argument of fillMaxWidth that is gonna make the Column have the
    //maxwidth of his father component that is the Surface component
    Column (
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment =  Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colorResource(id = R.color.background))
    ) {
        //Start - Column
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment =  Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.background))
                .padding(8.dp),
        ) {

//--------------------------------------------------------------------------------------------------------------------------------------

            Spacer(modifier = Modifier.height(28.dp))

            Row (modifier = Modifier.padding(5.dp)) {


                //Start - Component Text Field
                Text(
                    textAlign = TextAlign.Left,
                    text = stringResource(id = R.string.view_i_exerc_title),
                    color = Color.White,
                    //font with scale adaptable to the user preferences
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                //End - Component Text Field

            }


            //Start - Component Input Text Field
            InputTextField(
                valueItf = textoExercicio,
                placehItf = stringResource(id = R.string.view_i_exerc_ph_ex),
                placeHminHeightItf = 300,
                placeHModifier = Modifier.fillMaxWidth(),
                keyboardTypeItf = KeyboardType.Ascii,
                modifierItf = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 300.dp),
                textstyleItf = TextStyle(color = Color.White, fontSize = 18.sp),
                txtInputChangeItf = {
                    inputExerciseViewModel.onTextoExercicioChange(it)
                },
                spacerTop = 28,
                spacerBott = 28,
            )
            //End - Component Input Text Field


//--------------------------------------------------------------------------------------------------------------------------------------

            //Start - Component Text Field
            Text(
                textAlign = TextAlign.Justify,
                text = stringResource(id = R.string.view_i_exerc_sbttle),
                color = Color.White,
                //font with scale adaptable to the user preferences
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            //End - Component Text Field

            Spacer(modifier = Modifier.height(28.dp))


//---------------------------------------A-----------------------------------------------------------------------------------------------

            //Start - Component Row A

            InputAnswerRow(
                valueIar = textoA,
                txtInputChangeIar = {
                    inputExerciseViewModel.onTextoAChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_a),
                btnClearonClickIar = {
                    inputExerciseViewModel.onTextoAChange("")
                },
                spacerBottIar = 28,
                isSelected = altSelectd == "A",
                onOptionSelected = { altSelectd = "A"},
            )

//---------------------------------------B-----------------------------------------------------------------------------------------------

            //Start - Component Row B

            InputAnswerRow(
                valueIar = textoB,
                txtInputChangeIar = {
                    inputExerciseViewModel.onTextoBChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_b),
                btnClearonClickIar = {
                    inputExerciseViewModel.onTextoBChange("")
                },
                spacerBottIar = 28,
                isSelected = altSelectd == "B",
                onOptionSelected = { altSelectd = "B"},
            )
//---------------------------------------C-----------------------------------------------------------------------------------------------

            //Start - Component Row C

            InputAnswerRow(
                valueIar = textoC,
                txtInputChangeIar = {
                    inputExerciseViewModel.onTextoCChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_c),
                btnClearonClickIar = {
                    inputExerciseViewModel.onTextoCChange("")
                },
                spacerBottIar = 28,
                isSelected = altSelectd == "C",
                onOptionSelected = { altSelectd = "C"},
            )

            //---------------------------------------D-----------------------------------------------------------------------------------------------

            //Start - Component Row D

            InputAnswerRow(
                valueIar = textoD,
                txtInputChangeIar = {
                    inputExerciseViewModel.onTextoDChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_d),
                btnClearonClickIar = {
                    inputExerciseViewModel.onTextoDChange("")
                },
                spacerBottIar = 28,
                isSelected = altSelectd == "D",
                onOptionSelected = { altSelectd = "D"},
            )

            //---------------------------------------E-----------------------------------------------------------------------------------------------

            //Start - Component Row E

            InputAnswerRow(
                valueIar = textoE,
                txtInputChangeIar = {
                    inputExerciseViewModel.onTextoEChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_e),
                btnClearonClickIar = {
                    inputExerciseViewModel.onTextoEChange("")
                },
                spacerBottIar = 28,
                isSelected = altSelectd == "E",
                onOptionSelected = { altSelectd = "E"},
            )
//--------------------------------------------------------------------------------------------------------------------------------------

            //Start - Component Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,

                ) {
                Button(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(2.dp, colorResource(id = R.color.purple_200)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0x32FFFFFF))

                ) {
                    Text(text = stringResource(id = R.string.view_i_exerc_btn_plus))
                }
            }
            //End - Component Row

            //Start - Component Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = {
                        inputExerciseViewModel.onTextoExercicioChange("")
                        inputExerciseViewModel.onTextoAChange("")
                        inputExerciseViewModel.onTextoBChange("")
                        inputExerciseViewModel.onTextoCChange("")
                        inputExerciseViewModel.onTextoDChange("")
                        inputExerciseViewModel.onTextoEChange("")
                    },
                    border = BorderStroke(2.dp, colorResource(id = R.color.purple_200)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0x32FFFFFF))
                ) {
                    Text(
                        text = stringResource(id = R.string.view_i_exerc_btn_clear)
                    )
                }
                Button(
                    onClick = {
                        val dataObjExercise = DataObjExercise(
                            id = 0,
                            txtexerc = textoExercicio,
                            txtAltA = textoA,
                            txtAltB = textoB,
                            txtAltC = textoC,
                            txtAltD = textoD,
                            txtAltE = textoE,
                            correctAlt = altSelectd
                        )
                        dataObjExerciseRepository.save(dataObjExercise)

                        val msgExSaved = "Exercício salvo com sucesso!"
                        navController.navigate("ListExercise/$msgExSaved")

                    },
                    border = BorderStroke(2.dp, colorResource(id = R.color.purple_200)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0x32FFFFFF))
                ) {
                    Text(text = stringResource(id = R.string.view_i_exerc_btn_save))
                }
            }
            //End - Component Row

        }

        //End - Column
    }
    //End - Main Column
}
//End - Function MyComponent


//--------------------------------------------------------------------------------------------------------------------------------------

