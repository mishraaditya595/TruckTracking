package xyz.theadityamishra.trucktracking.model.AdminDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "issue")
data class IssueModel(
    @PrimaryKey
    val num: Long,
    val name: String,
    val issue: String
)
