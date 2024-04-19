package br.com.educonect.educonect.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_exercise")
data class DataObjExercise(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "txt_exerc") var txtexerc: String = "",
    @ColumnInfo(name = "txt_alt_a") var txtAltA: String = "",
    @ColumnInfo(name = "txt_alt_b") var txtAltB: String = "",
    @ColumnInfo(name = "txt_alt_c") var txtAltC: String = "",
    @ColumnInfo(name = "txt_alt_d") var txtAltD: String = "",
    @ColumnInfo(name = "txt_alt_e") var txtAltE: String = "",
    @ColumnInfo(name = "correct_alt") var correctAlt: String = ""
)
