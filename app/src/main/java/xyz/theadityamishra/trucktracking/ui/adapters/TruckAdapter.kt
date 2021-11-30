package xyz.theadityamishra.trucktracking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import xyz.theadityamishra.trucktracking.databinding.ItemTruckContainerBinding
import xyz.theadityamishra.trucktracking.model.TruckDB.TruckModel

class TruckAdapter(): RecyclerView.Adapter<TruckAdapter.TruckViewHolder>() {

    lateinit var binding: ItemTruckContainerBinding

    inner class TruckViewHolder(binding: ItemTruckContainerBinding): RecyclerView.ViewHolder(binding.root) {}

    val diffCallback = object : DiffUtil.ItemCallback<TruckModel>() {
        override fun areItemsTheSame(oldItem: TruckModel, newItem: TruckModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TruckModel, newItem: TruckModel) =
            oldItem.hashCode() == newItem.hashCode()
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<TruckModel>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TruckViewHolder {
        binding = ItemTruckContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TruckViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TruckViewHolder, position: Int) {
        val item = differ.currentList[position]
        binding.truckNumTv.text = item.id
        binding.currentLocationTv.text = item.currentLocation
        val fromTo = item.start + " -> " + item.end
        binding.fromToTv.text = fromTo
        val cargo = "${item.cargoType} (${item.loadAmount})"
        binding.cargoTypeLoadTv.text = cargo
        binding.modelCondTv.text = "${item.model} (${item.status})"
    }

    override fun getItemCount() = differ.currentList.size
}