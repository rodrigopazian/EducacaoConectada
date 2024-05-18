package br.com.educonect.educonect.views

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.educonect.educonect.database.repository.DataObjExerciseRepository
import br.com.educonect.educonect.model.DataObjExercise

class EditInputExerciseViewModel : ViewModel() {

    //ATRIBUTES

    private val _textoExercicio = MutableLiveData<String>()
    val textoExercicio: LiveData<String> = _textoExercicio

    private val _textoA = MutableLiveData<String>()
    val textoA: LiveData<String> = _textoA

    private val _textoB = MutableLiveData<String>()
    val textoB: LiveData<String> = _textoB

    private val _textoC = MutableLiveData<String>()
    val textoC: LiveData<String> = _textoC

    private val _textoD = MutableLiveData<String>()
    val textoD: LiveData<String> = _textoD

    private val _textoE = MutableLiveData<String>()
    val textoE: LiveData<String> = _textoE




    //DECLARATION OF PRIVATE VARIABLE THAT CAN'T BE MODIFIED OR OBSERVED FROM OUTSIDE THIS CLASS
    private val _editInputExercise = MutableLiveData<DataObjExercise>()
    //DECLARATION OF A VARIABLE THAT GETS THE VALUE OF THE VARIABLE ABOVE SO IT CAN BE OBSERVED BUT NOT MODIFIED FROM OUTSIDE
    val editInputExercise: LiveData<DataObjExercise> = _editInputExercise


    //METHODS
    fun onTextoExercicioChange(novoTextoExercicio: String) {
        _textoExercicio.value = novoTextoExercicio
    }
    fun onTextoAChange(novoTextoA: String) {
        _textoA.value = novoTextoA
    }

    fun onTextoBChange(novoTextoB: String) {
        _textoB.value = novoTextoB
    }

    fun onTextoCChange(novoTextoC: String) {
        _textoC.value = novoTextoC
    }

    fun onTextoDChange(novoTextoD: String) {
        _textoD.value = novoTextoD
    }

    fun onTextoEChange(novoTextoE: String) {
        _textoE.value = novoTextoE
    }



    fun editInputExerciseVMById(dataObjExerciseRepository: DataObjExerciseRepository,exerciseId: Long) : DataObjExercise? {
        Log.i(ContentValues.TAG, "EDITINPTVIEWMODEL 1 - ID LOG FUN DAOREPO ${dataObjExerciseRepository}")
        Log.i(ContentValues.TAG, "EDITINPTVIEWMODEL 2 - ID LOG FUN EXERCISEID ${exerciseId}")
        _editInputExercise.value = dataObjExerciseRepository.searchExerciseById(exerciseId)
        Log.i(ContentValues.TAG, "EDITINPTVIEWMODEL 3 - ID LOG FUN VALUE CHNAGE TO ${dataObjExerciseRepository.searchExerciseById(exerciseId)}")
        return editInputExercise.value
    }
//fun editInputExerciseVMById(dataObjExerciseRepository: DataObjExerciseRepository, exerciseId: Long): DataObjExercise? {
//
//    Log.i(ContentValues.TAG, "7 - ID LOG FUN DAOREPO ${dataObjExerciseRepository}")
//    Log.i(ContentValues.TAG, "8 - ID LOG FUN EXERCISEID ${exerciseId}")
//
//    val exercise = dataObjExerciseRepository.searchExerciseById(exerciseId)!!
//    Log.i(ContentValues.TAG, "9 - ID LOG FUN VALUE CHANGE TO $exercise")
//
//    if (exercise != null) {
//        _editInputExercise.value = exercise
//    } else {
//        Log.i(ContentValues.TAG, "10 - Exercise not found for ID: $exerciseId")
//    }
//    return exercise
//}
}