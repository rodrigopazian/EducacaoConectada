package br.com.educonect.educonect.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.educonect.educonect.model.DataObjExercise

@Database(
    entities = [DataObjExercise::class],
    version = 1
)
abstract class DataObjExerciseDB: RoomDatabase() {

    abstract fun dataObjExDAO(): DataObjExerciseDAO

    companion object {

        private lateinit var instance: DataObjExerciseDB

        fun getDB(context: Context): DataObjExerciseDB {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        DataObjExerciseDB::class.java,
                        "dataobjexercise_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}