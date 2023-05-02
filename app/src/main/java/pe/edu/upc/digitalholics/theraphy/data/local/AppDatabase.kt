package pe.edu.upc.digitalholics.theraphy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.digitalholics.theraphy.data.model.Patient
import pe.edu.upc.digitalholics.theraphy.data.model.Physiotherapist
import pe.edu.upc.digitalholics.theraphy.data.model.Review

@Database(entities = [Patient::class, Physiotherapist::class, Review::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){

    abstract fun patientDao(): PatientDao

    abstract fun physiotherapistDao(): PhysiotherapistDao

    abstract fun reviewDao(): ReviewDao

}