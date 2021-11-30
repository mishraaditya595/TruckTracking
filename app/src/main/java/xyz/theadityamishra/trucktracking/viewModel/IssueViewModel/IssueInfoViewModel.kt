package xyz.theadityamishra.trucktracking.viewModel.IssueViewModel

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import xyz.theadityamishra.trucktracking.model.AdminDB.IssueDB
import xyz.theadityamishra.trucktracking.model.AdminDB.IssueModel
import xyz.theadityamishra.trucktracking.model.AdminDB.IssueRepository
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckDB
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckModel
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckRepository

@InternalCoroutinesApi
public class IssueInfoViewModel(context: Context): ViewModel() {

    private val repo: IssueRepository
    val issue = MediatorLiveData<List<IssueModel>>()
//    val filteredData = MediatorLiveData<List<TruckModel>>()

    init {
        val issueDao = IssueDB.getDatabase(context).issueDao()
        repo = IssueRepository(issueDao)
        val getAllData = repo.getAllData()
        issue.addSource(getAllData) {
            it?.let { issue.value = it }
        }
    }

    fun saveData(data: IssueModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addData(data)
        }
    }

    fun deleteData(data: IssueModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteData(data)
        }
    }

//    fun filterData(id: String) = repo.filterData(id)

}