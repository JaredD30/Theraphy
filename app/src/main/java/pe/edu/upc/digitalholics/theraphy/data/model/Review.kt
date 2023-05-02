package pe.edu.upc.digitalholics.theraphy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "review")
data class Review(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "patient_starts")
    val stars: String,

    @ColumnInfo(name = "patient_description")
    val description: String
){
    constructor(): this("","","")

    @Ignore
    @SerializedName("patient")
    val patient: Patient = Patient()

    @Ignore
    @SerializedName("physiotherapist")
    val physiotherapist: Physiotherapist = Physiotherapist()
}
