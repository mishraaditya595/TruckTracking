package xyz.theadityamishra.trucktracking.ui

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.InternalCoroutinesApi
import xyz.theadityamishra.trucktracking.R
import xyz.theadityamishra.trucktracking.databinding.FragmentDriverBinding
import xyz.theadityamishra.trucktracking.model.TruckModel
import xyz.theadityamishra.trucktracking.repository.Repositoy
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModel
import xyz.theadityamishra.trucktracking.viewModel.TruckInfoViewModelFactory

@InternalCoroutinesApi
class DriverFragment : Fragment() {

    private lateinit var binding: FragmentDriverBinding
    private lateinit var viewModel: TruckInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_driver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDriverBinding.bind(view)

        val repository = Repositoy()
        val viewModelFactory = TruckInfoViewModelFactory(requireContext(), repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[TruckInfoViewModel::class.java]

        Toast.makeText(requireContext(),"GGGG", Toast.LENGTH_SHORT).show()



        binding.submitBtn.setOnClickListener {
            val truckModel = TruckModel(
                "binding.truckNumTextinputlayout.editText?.text.toString()",
                binding.startEt.text.toString(),
                binding.endEt.text.toString(),
                13.4F,
                binding.locationEt.text.toString(),
                binding.statusEt.text.toString(),
                binding.cargoEt.text.toString(),
                binding.loadEt.text.toString(),
                binding.modelEt.text.toString()
            )
            viewModel.saveData(truckModel)
            Snackbar.make(view,"Saved", Snackbar.LENGTH_SHORT).show()
        }
    }

}