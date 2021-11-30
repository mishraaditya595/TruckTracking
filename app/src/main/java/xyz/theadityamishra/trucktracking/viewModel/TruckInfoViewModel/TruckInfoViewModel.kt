package xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckDB
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckModel
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckRepository

@InternalCoroutinesApi
public class TruckInfoViewModel(context: Context): ViewModel() {

    private val repo: TruckRepository
    val trucks = MediatorLiveData<List<TruckModel>>()
    val filteredData = MediatorLiveData<List<TruckModel>>()

    init {
        val truckDao = TruckDB.getDatabase(context).truckDao()
        repo = TruckRepository(truckDao)
        val getAllData = repo.getAllData()
        trucks.addSource(getAllData) {
            it?.let { trucks.value = it }
        }
    }

    fun saveData(data: TruckModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addData(data)
        }
    }

    fun deleteData(data: TruckModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteData(data)
        }
    }

    fun filterData(id: String) = repo.filterData(id)

}