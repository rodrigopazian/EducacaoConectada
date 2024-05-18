package br.com.educonect.educonect.views

import android.content.ContentValues.TAG
import android.util.Log
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
fun EditInputExerciseView(
    editInputExerciseViewModel: EditInputExerciseViewModel,
    navController: NavController,
    exId: Long?,
) {

    Log.i(TAG, "EDITINPTVIEW 1 - ID LOG LONG ${exId}")
    //Start - Var Val Declarations
    val contextFunctionEditInputView = LocalContext.current
    val dataObjExerciseRepository = DataObjExerciseRepository(contextFunctionEditInputView)

    Log.i(TAG, "EDITINPTVIEW 2 - ID LOG CONTEXT ${contextFunctionEditInputView}")
    Log.i(TAG, "EDITINPTVIEW 3 - ID LOG REPO ${dataObjExerciseRepository}")
    val idLong = exId!!.toLong()
    val exidobj = editInputExerciseViewModel.editInputExerciseVMById(dataObjExerciseRepository, idLong!!)
    //var idTxtExercise by remember { mutableStateOf("") }
    val exerciseIdObj by editInputExerciseViewModel.editInputExercise.observeAsState(
        initial = editInputExerciseViewModel.editInputExerciseVMById(dataObjExerciseRepository, idLong)
    )

    Log.i(TAG, "EDITINPTVIEW 4 - ID LOG EXERCISEIDOBJinitial ${exidobj}")
    Log.i(TAG, "EDITINPTVIEW 5 - ID LOG EXERCISEIDOBJ ${exerciseIdObj}")
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


            Log.i(TAG, "EDITINPTVIEW 6 - ID LOG TXTEXERC ${exerciseIdObj!!.txtexerc}")
            //Start - Component Input Text Field
            InputTextField(
                valueItf = exerciseIdObj!!.txtexerc,
                placehItf = stringResource(id = R.string.view_i_exerc_ph_ex),
                placeHminHeightItf = 300,
                placeHModifier = Modifier.fillMaxWidth(),
                keyboardTypeItf = KeyboardType.Ascii,
                modifierItf = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 300.dp),
                textstyleItf = TextStyle(color = Color.White, fontSize = 18.sp),
                txtInputChangeItf = {
                    editInputExerciseViewModel.onTextoExercicioChange(it)
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
                valueIar = exerciseIdObj!!.txtAltA,
                txtInputChangeIar = {
                    editInputExerciseViewModel.onTextoAChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_a),
                btnClearonClickIar = {
                    editInputExerciseViewModel.onTextoAChange("")
                },
                spacerBottIar = 28,
                isSelected = exerciseIdObj!!.correctAlt == "A",
                onOptionSelected = { exerciseIdObj!!.correctAlt = "A"},
            )

//---------------------------------------B-----------------------------------------------------------------------------------------------

            //Start - Component Row B

            InputAnswerRow(
                valueIar = exerciseIdObj!!.txtAltB,
                txtInputChangeIar = {
                    editInputExerciseViewModel.onTextoBChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_b),
                btnClearonClickIar = {
                    editInputExerciseViewModel.onTextoBChange("")
                },
                spacerBottIar = 28,
                isSelected = exerciseIdObj!!.correctAlt == "B",
                onOptionSelected = { exerciseIdObj!!.correctAlt = "B"},
            )
//---------------------------------------C-----------------------------------------------------------------------------------------------

            //Start - Component Row C

            InputAnswerRow(
                valueIar = exerciseIdObj!!.txtAltC,
                txtInputChangeIar = {
                    editInputExerciseViewModel.onTextoCChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_c),
                btnClearonClickIar = {
                    editInputExerciseViewModel.onTextoCChange("")
                },
                spacerBottIar = 28,
                isSelected = exerciseIdObj!!.correctAlt == "C",
                onOptionSelected = { exerciseIdObj!!.correctAlt = "C"},
            )

            //---------------------------------------D-----------------------------------------------------------------------------------------------

            //Start - Component Row D

            InputAnswerRow(
                valueIar = exerciseIdObj!!.txtAltD,
                txtInputChangeIar = {
                    editInputExerciseViewModel.onTextoDChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_d),
                btnClearonClickIar = {
                    editInputExerciseViewModel.onTextoDChange("")
                },
                spacerBottIar = 28,
                isSelected = exerciseIdObj!!.correctAlt == "D",
                onOptionSelected = { exerciseIdObj!!.correctAlt = "D"},
            )

            //---------------------------------------E-----------------------------------------------------------------------------------------------

            //Start - Component Row E

            InputAnswerRow(
                valueIar = exerciseIdObj!!.txtAltE,
                txtInputChangeIar = {
                    editInputExerciseViewModel.onTextoEChange(it)
                },
                txtAltIar = stringResource(id = R.string.view_i_exerc_alt_e),
                btnClearonClickIar = {
                    editInputExerciseViewModel.onTextoEChange("")
                },
                spacerBottIar = 28,
                isSelected = exerciseIdObj!!.correctAlt == "E",
                onOptionSelected = { exerciseIdObj!!.correctAlt = "E"},
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
                        editInputExerciseViewModel.onTextoExercicioChange("")
                        editInputExerciseViewModel.onTextoAChange("")
                        editInputExerciseViewModel.onTextoBChange("")
                        editInputExerciseViewModel.onTextoCChange("")
                        editInputExerciseViewModel.onTextoDChange("")
                        editInputExerciseViewModel.onTextoEChange("")
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
                            txtexerc = exerciseIdObj!!.txtexerc,
                            txtAltA = exerciseIdObj!!.txtAltA,
                            txtAltB = exerciseIdObj!!.txtAltB,
                            txtAltC = exerciseIdObj!!.txtAltC,
                            txtAltD = exerciseIdObj!!.txtAltD,
                            txtAltE = exerciseIdObj!!.txtAltE,
                            correctAlt = exerciseIdObj!!.correctAlt
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

