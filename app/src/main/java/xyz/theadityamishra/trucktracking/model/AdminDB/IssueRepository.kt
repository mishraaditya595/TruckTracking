package xyz.theadityamishra.trucktracking.model.AdminDB

class IssueRepository(private val issueDao: IssueDao) {

    suspend fun addData(data: IssueModel) = issueDao.insertData(data)

    fun getAllData() = issueDao.readAllData()

    fun deleteData(data: IssueModel) = issueDao.deleteData(data)

//    fun filterData(id: String) = issueDao.filterData(id)
}