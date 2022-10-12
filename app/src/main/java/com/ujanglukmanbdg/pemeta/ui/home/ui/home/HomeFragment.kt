package com.ujanglukmanbdg.pemeta.ui.home.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.PengalamanPemeta
import com.ujanglukmanbdg.pemeta.databinding.FragmentHomeBinding
import com.ujanglukmanbdg.pemeta.ui.detail.experience.DetailExperienceActivity
import com.ujanglukmanbdg.pemeta.ui.detail.profile.CompanyProfileActivity

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val listExperience= ArrayList<PengalamanPemeta>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        listExperience.addAll(listPengalamanPemetas)

        toolbarHide()

        slideshow()

        homeMenu()

        homeViewModel.text.observe(viewLifecycleOwner) {}
        return root

    }

    private fun toolbarHide() {
        binding.apply {
            (requireActivity() as AppCompatActivity).supportActionBar?.isHideOnContentScrollEnabled
        }
    }

    private val listPengalamanPemetas: ArrayList<PengalamanPemeta>
    get() {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.getIntArray(R.array.data_photo)
        val dataCompanyUser = resources.getStringArray(R.array.data_company_user)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataYearsExperiences = resources.getStringArray(R.array.data_year_experiences)
        val dataContractJoint = resources.getStringArray(R.array.data_contract_joint)
        val dataContractAmount = resources.getStringArray(R.array.data_contract_amount)
        val dataAboutExperiences = resources.getStringArray(R.array.data_about_experiences)

        val listPengalamanPemeta = ArrayList<PengalamanPemeta>()
        for (i in dataName.indices) {
            val pengalamanPemeta = PengalamanPemeta(
                dataName[i],
                dataPhoto[i],
                dataCompanyUser[i],
                dataAboutExperiences[i],
                dataLocation[i],
                dataContractJoint[i],
                dataContractAmount[i],
                dataYearsExperiences[i],
            )
            listPengalamanPemeta.add(pengalamanPemeta)
        }
        return listPengalamanPemeta
    }

    private fun slideshow() {

        binding.homeSlideshow1.setOnClickListener { view ->
            val dataPengalamanPemeta = PengalamanPemeta (
                name = resources.getString(R.string.data_name1),
                photo = R.drawable.slideshow_01,
                companyUser = resources.getString(R.string.data_company_user1),
                aboutExperience = resources.getString(R.string.data_about_experiences1),
                location = resources.getString(R.string.data_location1),
                contract_amount = resources.getString(R.string.data_contract_amount1),
                contract_jo = resources.getString(R.string.data_contract_jo1),
                yearExperience = resources.getString(R.string.data_year_experiences1),
                    )

            val homeSlideshow1Intent = Intent(activity, DetailExperienceActivity::class.java)

            homeSlideshow1Intent.putExtra(DetailExperienceActivity.EXTRA_USER, dataPengalamanPemeta)
            startActivity(homeSlideshow1Intent)

        }

        binding.homeSlideshow2.setOnClickListener { view ->
            Snackbar.make(view, "Kunjungan lapangan Menteri PUPR - 2021", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurProject)
                .setAction("Action", null).show()

            val dataPengalamanPemeta = PengalamanPemeta (
                name = resources.getString(R.string.data_name2),
                photo = R.drawable.slideshow_02,
                companyUser = resources.getString(R.string.data_company_user2),
                aboutExperience = resources.getString(R.string.data_about_experiences2),
                location = resources.getString(R.string.data_location2),
                contract_amount = resources.getString(R.string.data_contract_amount2),
                contract_jo = resources.getString(R.string.data_contract_jo2),
                yearExperience = resources.getString(R.string.data_year_experiences2),
            )

            val homeSlidesho21Intent = Intent(activity, DetailExperienceActivity::class.java)

            homeSlidesho21Intent.putExtra(DetailExperienceActivity.EXTRA_USER, dataPengalamanPemeta)
            startActivity(homeSlidesho21Intent)
        }

        binding.homeSlideshow3.setOnClickListener { view ->
            Snackbar.make(view, "Pengawasan Jalan Planjan-Baron-Tepus - 2021", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurProject)
                .setAction("Action", null).show()

            val dataPengalamanPemeta = PengalamanPemeta (
                name = resources.getString(R.string.data_name3),
                photo = R.drawable.slideshow_03,
                companyUser = resources.getString(R.string.data_company_user3),
                aboutExperience = resources.getString(R.string.data_about_experiences3),
                location = resources.getString(R.string.data_location3),
                contract_amount = resources.getString(R.string.data_contract_amount3),
                contract_jo = resources.getString(R.string.data_contract_jo3),
                yearExperience = resources.getString(R.string.data_year_experiences3),
            )

            val homeSlidesho21Intent = Intent(activity, DetailExperienceActivity::class.java)

            homeSlidesho21Intent.putExtra(DetailExperienceActivity.EXTRA_USER, dataPengalamanPemeta)
            startActivity(homeSlidesho21Intent)
        }

        binding.homeSlideshow4.setOnClickListener { view ->
            Snackbar.make(view, "Kunjungan Kasatker dan Kabalai Jalur Lintas Selatan - 2022", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurProject)
                .setAction("Action", null).show()

            val dataPengalamanPemeta = PengalamanPemeta (
                name = resources.getString(R.string.data_name4),
                photo = R.drawable.slideshow_04,
                companyUser = resources.getString(R.string.data_company_user4),
                aboutExperience = resources.getString(R.string.data_about_experiences4),
                location = resources.getString(R.string.data_location4),
                contract_amount = resources.getString(R.string.data_contract_amount4),
                contract_jo = resources.getString(R.string.data_contract_jo4),
                yearExperience = resources.getString(R.string.data_year_experiences4),
            )

            val homeSlidesho21Intent = Intent(activity, DetailExperienceActivity::class.java)

            homeSlidesho21Intent.putExtra(DetailExperienceActivity.EXTRA_USER, dataPengalamanPemeta)
            startActivity(homeSlidesho21Intent)
        }
    }

    private fun homeMenu() {
        binding.includeMenuFrontPemeta.homePortfolio.setOnClickListener {  view ->
            Snackbar.make(view, "Portfolio Pemeta", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homePortfolio)
                .setAction("Action", null).show()

        }

        binding.includeMenuFrontPemeta.homeOurProject.setOnClickListener {  view ->
            Snackbar.make(view, "Project Pemeta", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurProject)
                .setAction("Action", null).show()

        }

        binding.includeMenuFrontPemeta.homeOurClient.setOnClickListener {  view ->
            Snackbar.make(view, "Client Pemeta", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurClient)
                .setAction("Action", null).show()

        }

        binding.includeMenuFrontPemeta.homeOurExperience.setOnClickListener {  view ->
            Snackbar.make(view, "Pengalaman Pemeta", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurExperience)
                .setAction("Action", null).show()

        }

        binding.includeMenuFrontPemeta.homeOurExperts.setOnClickListener {  view ->
            Snackbar.make(view, "Tenaga Experts Pemeta", Snackbar.LENGTH_LONG)
                .setAnchorView(binding.includeMenuFrontPemeta.homeOurExperts)
                .setAction("Action", null).show()

        }

        binding.includeMenuFrontPemeta.homeAboutUs.setOnClickListener { view ->

            // Snackbar.make(view, "Tentang Pemeta", Snackbar.LENGTH_LONG)
            //    .setAnchorView(binding.includeMenuFrontPemeta.homeAboutUs)
            //    .setAction("Action", null).show()

            val homeAboutUs = Intent(activity, CompanyProfileActivity::class.java)
            startActivity(homeAboutUs)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = this.binding
    }
}