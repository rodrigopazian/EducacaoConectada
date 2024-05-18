package br.com.educonect.educonect

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.educonect.educonect.ui.theme.EduconectTheme
import br.com.educonect.educonect.views.EditInputExerciseView
import br.com.educonect.educonect.views.EditInputExerciseViewModel
import br.com.educonect.educonect.views.InputExerciseView
import br.com.educonect.educonect.views.InputExerciseViewModel
import br.com.educonect.educonect.views.ListExerciseView
import br.com.educonect.educonect.views.ListExerciseViewModel
import br.com.educonect.educonect.views.LoginView

//--------------------------------------------------------------------------------------------------------------------------------------


//Start - Initial Class MainActivity that forms the screen and is called when the app is started
class MainActivity : ComponentActivity() {
    //Start - Initial Function called when the app is started
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Start - setContent Method that sets what is the content of our screen
        setContent {
            //Start - Component that calls the file theme that has all the dimensions colors that the components below will have
            EduconectTheme {
                //Start - Surface Component container using the 'background' color from the theme
                Surface(
                    //modifier argument - Is passing an argument of fillmaxWidth that is gonna make the Surface have the
                    //modifier argument - Is passing the colorScheme of the background
                    color = MaterialTheme.colorScheme.background,
                    //maxwidth of the screen because he is the first Component
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .background(Color(0xFF1C1C1C)),

                    ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginView(navController)
                        }
                        composable(route = "inputExercise") {
                            InputExerciseView(
                                InputExerciseViewModel(),
                                navController,
                            )
                        }
                        composable(route = "listExercise/{msgExController}") {
                            val msgExController = it.arguments?.getString("msgExController")
                            ListExerciseView(
                                ListExerciseViewModel(),
                                navController,
                                msgExController!!
                            )
                        }
//                        composable(route = "editexercise/{id}") {
//                          val id = it.arguments?.getString("id", 1)!!
////                          val exerciseId = 1L
//                            Log.i(ContentValues.TAG, "MAINACTIVITY 1 - ID LOG LONG $id")
//                            EditInputExerciseView(
//                                EditInputExerciseViewModel(),
//                                navController,
//                                id
//                            )
//                        }
                        composable(
                            route = "editexercise?id={id}",
                            arguments = listOf(navArgument(name = "id"){
                                defaultValue = 1L
                            })
                        ) {
                            EditInputExerciseView(
                                EditInputExerciseViewModel(),
                                navController,
                                it.arguments?.getLong("id")                            )
                        }
                    }
//
                }
                //End - Surface Component container using the 'background' color from the theme
            }
            //End - Component that calls the file theme that has all the dimensions colors that the components below will have
        }
        //End -  setContent Method that sets what is the content of our screen
    }
    //End - Initial Function called when the app is started
}
//End - Initial Class MainActivity that forms the screen and is called when the app is started


//@Preview(showBackground = true,showSystemUi = true)
//@Composable
//fun MyComponentPreview()
//{
//    InputExerciseView(InputExerciseViewModel(), navController)
//}