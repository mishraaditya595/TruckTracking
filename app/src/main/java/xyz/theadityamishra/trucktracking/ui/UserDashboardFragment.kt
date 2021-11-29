package xyz.theadityamishra.trucktracking.ui

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.coroutines.InternalCoroutinesApi
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentUserDashboardBinding
import xyz.theadityamishra.trucktracking.databinding.ItemTruckContainerBinding
import xyz.theadityamishra.trucktracking.repository.Repositoy
import xyz.theadityamishra.trucktracking.ui.adapters.TruckAdapter
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModelFactory

@InternalCoroutinesApi
class UserDashboardFragment : Fragment() {

    private lateinit var binding: FragmentUserDashboardBinding
    private lateinit var truckAdapter: TruckAdapter
    private lateinit var viewModel: TruckInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserDashboardBinding.bind(view)

        val repositoy = Repositoy()
        val viewModelFactory = TruckInfoViewModelFactory(requireContext(), repositoy)
        viewModel = ViewModelProvider(this, viewModelFactory)[TruckInfoViewModel::class.java]

        setupRecyclerView()

        viewModel.trucks.observe(viewLifecycleOwner, Observer {
            truckAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        binding.allInfoRv.apply {
            truckAdapter = TruckAdapter()
            adapter =  truckAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

}