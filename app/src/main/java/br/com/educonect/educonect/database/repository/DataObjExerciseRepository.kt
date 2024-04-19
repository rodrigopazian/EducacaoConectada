package br.com.educonect.educonect.database.repository

import android.content.Context
import br.com.educonect.educonect.database.dao.DataObjExerciseDB
import br.com.educonect.educonect.model.DataObjExercise

class DataObjExerciseRepository(context: Context) {

    var db = DataObjExerciseDB.getDB(context).dataObjExDAO()

    fun save(dataObjExercise: DataObjExercise): Long {
        return db.save(dataObjExercise = dataObjExercise)
    }

    fun update(dataObjExercise: DataObjExercise): Int {
        return db.update(dataObjExercise = dataObjExercise)
    }

    fun delete(dataObjExercise: DataObjExercise): Int {
        return db.delete(dataObjExercise = dataObjExercise)
    }

    fun searchExerciseById(id: Long): DataObjExercise {
        return db.searchExerciseById(id = id)
    }

    fun listExercises(): List<DataObjExercise> {
        return db.listExercises()
    }
}