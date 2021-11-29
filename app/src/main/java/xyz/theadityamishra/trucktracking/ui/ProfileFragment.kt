package xyz.theadityamishra.trucktracking.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val args by navArgs<ProfileFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val arg = args.userType

        binding.addTruckCv.setOnClickListener {
            if (arg.equals("D"))
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_driverFragment)
            else
                Toast.makeText(requireContext(),"You are not allowed to open it", Toast.LENGTH_SHORT).show()
        }

        binding.seeTruckCv.setOnClickListener {
            if (arg.equals("U"))
                Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_dashboardFragment)
            else
                Toast.makeText(requireContext(),"You are not allowed to open it", Toast.LENGTH_SHORT).show()
        }

    }
}