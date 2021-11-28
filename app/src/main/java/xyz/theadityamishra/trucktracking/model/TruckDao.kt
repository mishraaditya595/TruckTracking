package xyz.theadityamishra.trucktracking.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TruckDao {

    @Query("SELECT * FROM truck")
    fun readAllData(): LiveData<List<TruckModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(truckData: TruckModel)

    @Delete
    fun deleteData(truckData: TruckModel)
}