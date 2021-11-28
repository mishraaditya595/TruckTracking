package xyz.theadityamishra.trucktracking.model

class TruckRepository(private val truckDao: TruckDao) {

    suspend fun addData(data: TruckModel) = truckDao.insertData(data)

    fun getAllData() = truckDao.readAllData()

    fun deleteData(data: TruckModel) = truckDao.deleteData(data)

}