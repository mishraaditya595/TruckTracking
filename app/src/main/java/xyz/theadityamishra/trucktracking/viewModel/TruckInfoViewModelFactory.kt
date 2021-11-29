package xyz.theadityamishra.trucktracking.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.InternalCoroutinesApi
import xyz.theadityamishra.trucktracking.repository.Repositoy

@InternalCoroutinesApi
class TruckInfoViewModelFactory (private val context: Context, private val repository: Repositoy): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TruckInfoViewModel(context) as T
    }
}