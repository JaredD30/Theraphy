package pe.edu.upc.digitalholics.theraphy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "patient")
data class Patient(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "patient_first_name")
    val firstName: String,

    @ColumnInfo(name = "patient_last_name")
    val lastName: String,

    @ColumnInfo(name = "patient_age")
    val age: String,

    @ColumnInfo(name = "patient_birthday")
    val birthdayDate: String,

    @ColumnInfo(name = "patient_email")
    val email: String,

    @ColumnInfo(name = "patient_appointment_quantity")
    val appointmentQuantity: String,

    @ColumnInfo(name = "patient_photo_url")
    val photoUrl: String
){
    constructor():this("","","","","","","","")

}
