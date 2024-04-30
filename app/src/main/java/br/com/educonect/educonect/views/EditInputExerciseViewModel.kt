package br.com.educonect.educonect.views

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
        _editInputExercise.value = dataObjExerciseRepository.searchExerciseById(exerciseId)
        return editInputExercise.value
    }
}