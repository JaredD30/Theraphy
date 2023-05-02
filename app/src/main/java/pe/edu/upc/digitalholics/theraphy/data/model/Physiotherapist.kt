package pe.edu.upc.digitalholics.theraphy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "physiotherapist")
data class Physiotherapist(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "physiotherapist_first_name")
    val firstName: String,

    @ColumnInfo(name = "physiotherapist_paternal_surname")
    val paternalSurname: String,

    @ColumnInfo(name = "physiotherapist_maternal_surname")
    val maternalSurname: String,

    @ColumnInfo(name = "physiotherapist_specialization")
    val specialization: String,

    @ColumnInfo(name = "physiotherapist_age")
    val age: String,

    @ColumnInfo(name = "physiotherapist_location")
    val location: String,

    @ColumnInfo(name = "physiotherapist_birthday")
    val birthdayDate: String,

    @ColumnInfo(name = "physiotherapist_email")
    val email: String,

    @ColumnInfo(name = "physiotherapist_rating")
    val rating: String,

    @ColumnInfo(name = "physiotherapist_consultations_quantity")
    val consultationsQuantity: String,

    @ColumnInfo(name = "physiotherapist_photo_url")
    val photoUrl: String
){
    constructor(): this("","","","","","","","","","","","")

}

