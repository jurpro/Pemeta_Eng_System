package com.ujanglukmanbdg.pemeta.ui.sistempemeta.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.lapangan.KaryawanLapanganPemeta
import com.ujanglukmanbdg.pemeta.databinding.ActivityDetailPersonilBinding

class PersonilAdapter internal constructor(private val context: Context) : BaseAdapter() {
    private lateinit var binding: ActivityDetailPersonilBinding

    internal var employees = arrayListOf<KaryawanLapanganPemeta>()

    override fun getCount(): Int {
        return employees.size
    }

    override fun getItem(p0: Int): Any {
        return employees[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.activity_detail_personil, viewGroup, false)
        }
      //  val viewHolder = RecyclerView.ViewHolder(itemView as View)
        val employee = getItem(position) as KaryawanLapanganPemeta
     //   viewHolder.bind(employee)

        return itemView
    }

    private inner class ViewHolder(view: View?) {
        /* val lapanganName: view?.findViewById<TextView>(R.id.includeHeaderPersonilLapangan.headerDetailPersonilNama)
            get() {
                TODO()
            }
        val lapanganPhoto: Int,
        val lapanganJabatan: String,
        val lapanganAlamatKtp: String,
        val lapanganEmail: String,
        val lapanganContact: String,
        val lapanganKotaPenempatan: String,
        val lapanganSatkerPenempatan: String,
        val lapanganTugasPekerjaan: String,
        val lapanganPerusahaanKontrak: String,
        val lapanganMobilisasi: String,
        val lapanganDemobilisasi: String,


        fun bind(employee: KaryawanLapanganPemeta) {
            Glide.with(this)
                .load(employee.lapanganPhoto)
                .circleCrop()
                .into(binding.includeHeaderPersonilLapangan.headerDetailPersonilPhoto)
            binding.includeHeaderPersonilLapangan.headerDetailPersonilNama.text = employee.lapanganName
            binding.includeHeaderPersonilLapangan.headerDetailPersonilJabatan.text = employee.lapanganJabatan

            //Detail
            binding.includeDetailPersonilLapangan.personilDetailAlamatTeks.text = employee.lapanganAlamatKtp
            binding.includeDetailPersonilLapangan.personilDetailEmailTeks.text = employee.lapanganEmail
            binding.includeDetailPersonilLapangan.personilDetailContactTeks.text = employee.lapanganContact
            binding.includeDetailPersonilLapangan.personilDetailPenempatanTeks .text = employee.lapanganKotaPenempatan
            binding.includeDetailPersonilLapangan.personilDetailSatkerTeks.text = employee.lapanganSatkerPenempatan
            binding.includeDetailPersonilLapangan.personilDetailPekerjaanTeks.text = employee.lapanganTugasPekerjaan
            binding.includeDetailPersonilLapangan.personilDetailPerusahaanTeks.text = employee.lapanganPerusahaanKontrak
            binding.includeDetailPersonilLapangan.personilDetailMobilisasiTeks.text = employee.lapanganMobilisasi
            binding.includeDetailPersonilLapangan.personilDetailDemobilisasiTeks.text = employee.lapanganDemobilisasi
        } */
    }
}