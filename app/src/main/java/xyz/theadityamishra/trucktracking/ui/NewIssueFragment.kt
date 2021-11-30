package xyz.theadityamishra.trucktracking.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.InternalCoroutinesApi
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentNewIssueBinding
import xyz.theadityamishra.trucktracking.model.AdminDB.IssueModel
import xyz.theadityamishra.trucktracking.repository.Repositoy
import xyz.theadityamishra.trucktracking.viewModel.IssueViewModel.IssueInfoViewModel
import xyz.theadityamishra.trucktracking.viewModel.IssueViewModel.IssueViewModelFactory
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel.TruckInfoViewModel
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel.TruckInfoViewModelFactory

@InternalCoroutinesApi
class NewIssueFragment : Fragment() {

    private lateinit var binding: FragmentNewIssueBinding
    private lateinit var viewModel: IssueInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_issue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewIssueBinding.bind(view)

        val repository = Repositoy()
        val viewModelFactory = IssueViewModelFactory(requireContext(),repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[IssueInfoViewModel::class.java]

        binding.buttonCard.setOnClickListener {
            val issue = IssueModel(
                binding.contactEt.text.toString().toLong(),
                binding.nameEt.text.toString(),
                binding.problemEt.text.toString()
            )

            viewModel.saveData(issue)
            Snackbar.make(view,"Saved",Snackbar.LENGTH_SHORT).show()
        }
    }


}