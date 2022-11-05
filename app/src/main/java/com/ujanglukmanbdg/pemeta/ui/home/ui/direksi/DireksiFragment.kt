package com.ujanglukmanbdg.pemeta.ui.home.ui.direksi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.PersonilPemeta
import com.ujanglukmanbdg.pemeta.databinding.FragmentDireksiBinding
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.profile.DetailPersonilActivity
import com.ujanglukmanbdg.pemeta.ui.home.ui.locations.LocationsFragment


class DireksiFragment : Fragment() {

    private var _binding: FragmentDireksiBinding? = null
    private lateinit var direksiViewModel: DireksiViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        } */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val direksiViewModel = ViewModelProvider(this).get(DireksiViewModel::class.java)

        _binding = FragmentDireksiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*
        val textView: TextView = binding.direksiTitle
        direksiViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        } */

        setDisplayDireksi()

        setToolbarHide()

        return root
    }

    private fun setDisplayDireksi() {
        val photoDirekturUtama = R.drawable.personil_luthfi_djatnika
        val photoDirektur = R.drawable.personil_lukman_size_kecil
        val photoKomisaris = R.drawable.personil_nia_restiana
        val photoPJTBU = R.drawable.personil_tito_irianto
        val photoPJSKBU = R.drawable.personil_surya_azan_resize

        val binderAlamat = R.drawable.binder_alamat

        binding.direksiPhotoDirut.setImageResource(photoDirekturUtama)

        Glide.with(this)
            .load(photoDirektur)
            .circleCrop()
            .into(binding.direksiDirekturPhoto)

        Glide.with(this)
            .load(photoKomisaris)
            .circleCrop()
            .into(binding.direksiKomisarisPhoto)

        Glide.with(this)
            .load(photoPJTBU)
            .circleCrop()
            .into(binding.direksiPjtbuPhoto)

        Glide.with(this)
            .load(photoPJSKBU)
            .circleCrop()
            .into(binding.direksiPjskbuPhoto)

        // binding.direksiDirekturPhoto.setImageResource(photoDirektur)
        // binding.direksiKomisarisPhoto.setImageResource(photoKomisaris)
        // binding.direksiPjtbuPhoto.setImageResource(photoPJTBU)
        // binding.direksiPjskbuPhoto.setImageResource(photoPJSKBU)

        binding.direksiBinderAlamat.setImageResource(binderAlamat)


        /*
        activity?.let {
            direksiViewModel.navigateToLocation.observe(it, Observer {
                it.getContentIfNotHandled()
                    ?.let { // Only proceed if the event has never been handled
                        startActivity(it)
                    }
            })
        }

         */

        binding.direksiBinderAlamat.setOnClickListener {  view ->
            Snackbar.make(view, "Location", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.direksiBinderAlamat)
                .setAction("Action", null).show()

        }

        onClickToDetailPersonil()
    }

    private fun onClickToDetailPersonil() {
        binding.direksiPhotoDirut.setOnClickListener {
            val dataPersonilPemeta = PersonilPemeta (
                personil_name = resources.getString(R.string.direksi_direktur_utama_nama),
                personil_photo = R.drawable.personil_luthfi_djatnika,
                personil_jabatan = resources.getString(R.string.direksi_direktur_utama_jabatan),
                personil_quote = resources.getString(R.string.detail_direktur_utama_quote),
                personil_paragraph1 = resources.getString(R.string.detail_direktur_utama_paragraph1),
                personil_paragraph2 = resources.getString(R.string.detail_direktur_utama_paragraph2),
                personil_paragraph3 = resources.getString(R.string.detail_direktur_utama_paragraph3),
                personil_connect = resources.getString(R.string.detail_direktur_utama_connect)
            )

            val direksiPhotoDirut = Intent(activity, DetailPersonilActivity::class.java)

            direksiPhotoDirut.putExtra(DetailPersonilActivity.EXTRA_USER_DETAIL, dataPersonilPemeta)
            startActivity(direksiPhotoDirut)
        }
    }

    private fun startActivity(it: String) {
        val locationPemeta = Intent(activity, LocationsFragment::class.java)
        startActivity(locationPemeta)

    }

    private fun setToolbarHide() {
        binding.apply {
            (requireActivity() as AppCompatActivity).supportActionBar?.isHideOnContentScrollEnabled
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DireksiFragment.
         */
        // TODO: Rename and change types and number of parameters
        /*
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DireksiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            } */
    }
}