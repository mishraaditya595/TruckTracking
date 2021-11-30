package xyz.theadityamishra.trucktracking.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import xyz.theadityamishra.trucktracking.databinding.ItemIssueContainerBinding
import xyz.theadityamishra.trucktracking.model.AdminDB.IssueModel

class IssueAdapter: RecyclerView.Adapter<IssueAdapter.IssueViewHolder>() {

    private lateinit var binding: ItemIssueContainerBinding

    inner class IssueViewHolder(binding: ItemIssueContainerBinding) : RecyclerView.ViewHolder(this.binding.root) {}

    val diffCallback = object : DiffUtil.ItemCallback<IssueModel>() {
        override fun areItemsTheSame(oldItem: IssueModel, newItem: IssueModel) =
            oldItem.num == newItem.num

        override fun areContentsTheSame(oldItem: IssueModel, newItem: IssueModel) =
            oldItem.hashCode() == newItem.hashCode()
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<IssueModel>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueAdapter.IssueViewHolder {
        binding = ItemIssueContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IssueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val item = differ.currentList[position]
        binding.issueTv.text = item.issue
        binding.nameTv.text = item.name
        binding.numTv.text = item.num.toString()
    }

    override fun getItemCount() = differ.currentList.size

}