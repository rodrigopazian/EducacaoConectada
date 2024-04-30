package br.com.educonect.educonect.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.educonect.educonect.database.repository.DataObjExerciseRepository
import br.com.educonect.educonect.model.DataObjExercise

class ListExerciseViewModel : ViewModel() {

    //ATRIBUTES


    //DECLARATION OF PRIVATE VARIABLE THAT CAN'T BE MODIFIED OR OBSERVED FROM OUTSIDE THIS CLASS
    private val _listTxtExercise = MutableLiveData<List<DataObjExercise>>()
    //DECLARATION OF A VARIABLE THAT GETS THE VALUE OF THE VARIABLE ABOVE SO IT CAN BE OBSERVED BUT NOT MODIFIED FROM OUTSIDE
    val listTxtExercise: LiveData<List<DataObjExercise>> = _listTxtExercise




    //METHODS

    fun listTxtExerciseVM(dataObjExerciseRepository: DataObjExerciseRepository) : List<DataObjExercise>? {
        _listTxtExercise.value = dataObjExerciseRepository.listExercises()
        return listTxtExercise!!.value
    }


}