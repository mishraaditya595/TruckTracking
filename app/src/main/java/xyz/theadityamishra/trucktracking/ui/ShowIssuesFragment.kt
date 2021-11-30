package xyz.theadityamishra.trucktracking.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.coroutines.InternalCoroutinesApi
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentShowIssuesBinding
import xyz.theadityamishra.trucktracking.model.AdminDB.IssueModel
import xyz.theadityamishra.trucktracking.repository.Repositoy
import xyz.theadityamishra.trucktracking.ui.adapters.IssueAdapter
import xyz.theadityamishra.trucktracking.ui.adapters.TruckAdapter
import xyz.theadityamishra.trucktracking.viewModel.IssueViewModel.IssueInfoViewModel
import xyz.theadityamishra.trucktracking.viewModel.IssueViewModel.IssueViewModelFactory
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel.TruckInfoViewModel
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel.TruckInfoViewModelFactory

@InternalCoroutinesApi
class ShowIssuesFragment : Fragment() {

    private lateinit var binding: FragmentShowIssuesBinding
    private lateinit var viewModel: IssueInfoViewModel
    private lateinit var issueAdapter: IssueAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_issues, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShowIssuesBinding.bind(view)

        val repositoy = Repositoy()
        val viewModelFactory = IssueViewModelFactory(requireContext(), repositoy)
        viewModel = ViewModelProvider(this, viewModelFactory)[IssueInfoViewModel::class.java]

        setupRecyclerView()

        viewModel.issue.observe(viewLifecycleOwner, Observer {
            issueAdapter.submitList(it)
        })

    }

    private fun setupRecyclerView() {
        binding.allIssuesRv.apply {
            issueAdapter = IssueAdapter()
            adapter = issueAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }
    }
}