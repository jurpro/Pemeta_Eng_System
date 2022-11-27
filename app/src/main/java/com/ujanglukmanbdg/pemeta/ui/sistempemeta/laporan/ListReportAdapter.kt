package com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseReport
import com.ujanglukmanbdg.pemeta.databinding.ItemListImageReportBinding
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan.DetailLaporanActivity.Companion.EXTRA_DATA

@ExperimentalPagingApi
class ListReportAdapter : PagingDataAdapter<ModelDatabaseReport, ListReportAdapter.ListViewHolder>(DIFF_CALLBACK)  {

    private lateinit var binding: ItemListImageReportBinding

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): ListViewHolder {

        binding = ItemListImageReportBinding.inflate(LayoutInflater.from(view.context),view,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val reportData = getItem(position)
        if (reportData != null) {
            holder.bind(reportData)
        }
    }

    class ListViewHolder(private var binding:ItemListImageReportBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listReportItem: ModelDatabaseReport){
            binding.apply {
                itemListNameDetailReport.text = listReportItem.name

                Glide.with(itemView.context)
                    .load(listReportItem.photo)
                    .into(itemListImgReport)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailLaporanActivity::class.java)
                    intent.putExtra(EXTRA_DATA, listReportItem)

                    val optionsCompat: ActivityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                            itemView.context as Activity,
                            Pair(itemListImgReport,"imageReport"),
                            Pair(itemListNameDetailReport,"nameReport"),
                            Pair(itemListLocationDetailReport, "lokasiReport"),
                            Pair(itemListDateDetailReport, "tanggalRepor"),
                            Pair(itemListJobDetailReport, "jobReport")
                        )

                    itemView.context.startActivity(intent, optionsCompat.toBundle())
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ModelDatabaseReport>() {
            override fun areItemsTheSame(oldItem: ModelDatabaseReport, newItem: ModelDatabaseReport): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: ModelDatabaseReport, newItem: ModelDatabaseReport): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}