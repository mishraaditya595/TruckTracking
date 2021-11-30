package xyz.theadityamishra.trucktracking.model.AdminDB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IssueDao {

    @Query("SELECT * FROM issue")
    fun readAllData(): LiveData<List<IssueModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(issueData: IssueModel)

    @Delete
    fun deleteData(issueData: IssueModel)

//    @Query("SELECT * FROM issue WHERE id LIKE '%' || :num || '%'")
//    fun filterData(num: String): List<IssueModel>
}