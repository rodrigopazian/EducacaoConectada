package br.com.educonect.educonect.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.educonect.educonect.R

@Composable
fun LoginView(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colorResource(id = R.color.background))
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .defaultMinSize(minHeight = 660.dp)
                .background(color = colorResource(id = R.color.background)),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment =  Alignment.CenterHorizontally,

        ) {
            Text(
                text = "LoginPage",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.purple_200)
            )
            Button(
                onClick = {

                    val msgExSaved = " "
                    navController.navigate("ListExercise/$msgExSaved")
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_200)),
            ) {
                Text(
                    text = "LOGAR",
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}