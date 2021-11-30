package xyz.theadityamishra.trucktracking.model.TruckDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "truck")
data class TruckModel(
    @PrimaryKey
    val id: String,
    val start: String,
    val end: String,
    val timeTaken: Float,
    val currentLocation: String,
    val status: String,
    val cargoType: String,
    val loadAmount: String,
    val model: String
)
