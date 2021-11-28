package xyz.theadityamishra.trucktracking.model

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface TruckDao {

    @Query("SELECT * FROM truck")
    fun readAllData(): LiveData<List<TruckModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(truckData: TruckModel)

    @Delete
    fun deleteData(truckData: TruckModel)
}