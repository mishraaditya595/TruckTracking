package xyz.theadityamishra.trucktracking.model.TruckDB

class TruckRepository(private val truckDao: TruckDao) {

    suspend fun addData(data: TruckModel) = truckDao.insertData(data)

    fun getAllData() = truckDao.readAllData()

    fun deleteData(data: TruckModel) = truckDao.deleteData(data)

    fun filterData(id: String) = truckDao.filterData(id)
}