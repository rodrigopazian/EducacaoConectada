package br.com.educonect.educonect.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputExerciseViewModel : ViewModel() {

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
}