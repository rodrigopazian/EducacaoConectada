package br.com.educonect.educonect.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.educonect.educonect.model.DataObjExercise

@Dao
interface DataObjExerciseDAO {

    @Insert
    fun save(dataObjExercise: DataObjExercise): Long

    @Update
    fun update(dataObjExercise: DataObjExercise): Int

    @Delete
    fun delete(dataObjExercise: DataObjExercise): Int

    @Query("SELECT * FROM tbl_exercise WHERE id = :id")
    fun searchExerciseById(id: Long): DataObjExercise

    @Query("SELECT * FROM tbl_exercise ORDER BY id ASC")
    fun listExercises(): List<DataObjExercise>

}