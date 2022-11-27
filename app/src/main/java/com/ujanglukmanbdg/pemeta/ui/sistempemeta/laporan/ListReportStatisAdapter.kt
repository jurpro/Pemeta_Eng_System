package com.ujanglukmanbdg.pemeta.ui.sistempemeta.laporan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporanStatis
import com.ujanglukmanbdg.pemeta.databinding.ItemListImageReportBinding

@Suppress("DEPRECATION")
class ListReportStatisAdapter(val listReportStatis: ArrayList<PhotoLaporanStatis>): RecyclerView.Adapter<ListReportStatisAdapter.ListViewHolder>() {
    private lateinit var binding: ItemListImageReportBinding

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_image_report, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo, job, location, date) = listReportStatis[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .into(holder.photoReport)
        holder.nameReport.text = name
        holder.jobReport.text = job
        holder.locationReport.text = location
        holder.dateReport.text = date
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listReportStatis[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listReportStatis.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photoReport: ImageView = itemView.findViewById(R.id.item_list_img_report)
        var nameReport: TextView = itemView.findViewById(R.id.item_list_name_detail_report)
        var jobReport: TextView = itemView.findViewById(R.id.item_list_job_detail_report)
        var locationReport: TextView = itemView.findViewById(R.id.item_list_location_detail_report)
        var dateReport: TextView = itemView.findViewById(R.id.item_list_date_detail_report)
    }

    interface OnItemClickCallback {
        fun onItemClicked(datareport: PhotoLaporanStatis)
    }
}