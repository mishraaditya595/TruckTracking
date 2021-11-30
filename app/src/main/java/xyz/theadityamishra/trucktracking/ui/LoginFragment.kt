package xyz.theadityamishra.trucktracking.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)



        binding.buttonCard.setOnClickListener {
            var flag: Char = 'Z'
            if (binding.usernameEt.text?.toString()?.equals("driver") == true)
                flag = 'D'
            else if (binding.usernameEt.text?.toString()?.equals("user") == true)
                flag = 'U'
            else if (binding.usernameEt.text?.toString()?.equals("admin") == true)
                flag = 'A'

            when(flag) {
                'D' -> {
                    val actions = LoginFragmentDirections.actionLoginFragmentToProfileFragment("D")
                    Navigation.findNavController(view).navigate(actions)
                }
                'U' -> {
                    val actions = LoginFragmentDirections.actionLoginFragmentToProfileFragment("U")
                    Navigation.findNavController(view).navigate(actions)
                }
                'A' -> Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_adminFragment)
                else -> Toast.makeText(requireContext(),"Invalid user name",Toast.LENGTH_SHORT).show()
            }

        }
    }

}