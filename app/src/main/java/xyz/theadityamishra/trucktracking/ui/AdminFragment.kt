package xyz.theadityamishra.trucktracking.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentAdminBinding
import xyz.theadityamishra.trucktracking.databinding.FragmentProfileBinding


class AdminFragment : Fragment() {

    private lateinit var binding: FragmentAdminBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdminBinding.bind(view)

        binding.seeTruckCv.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_adminFragment_to_dashboardFragment)
        }

        binding.addTruckCv.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_adminFragment_to_driverFragment)
        }

        binding.helpC.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_adminFragment_to_showIssuesFragment)
        }
    }

}