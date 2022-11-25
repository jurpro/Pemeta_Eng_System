package com.ujanglukmanbdg.pemeta.ui.sistempemeta.upload

import android.Manifest
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.ujanglukmanbdg.pemeta.R
import com.ujanglukmanbdg.pemeta.data.DataStories
import com.ujanglukmanbdg.pemeta.data.ListReportItem
import com.ujanglukmanbdg.pemeta.databinding.ActivityUploadBinding
import com.ujanglukmanbdg.pemeta.datastories.UserPreference
import com.ujanglukmanbdg.pemeta.datastories.reduceFileImage
import com.ujanglukmanbdg.pemeta.datastories.rotateBitmap
import com.ujanglukmanbdg.pemeta.datastories.uriToFile
import com.ujanglukmanbdg.pemeta.retrofit.ApiConfig
import com.ujanglukmanbdg.pemeta.ui.main.MainActivity
import com.ujanglukmanbdg.pemeta.ui.main.ViewModelFactory
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.DashboardSistemActivity
import com.ujanglukmanbdg.pemeta.ui.sistempemeta.camera.CameraActivity
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
@ExperimentalPagingApi
class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var token :String
    private var getFileImage: File? = null

    private lateinit var uploadViewModel: UploadViewModel

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var currentLocation: Location? = null

    // Date
    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        token = intent.getStringExtra(EXTRA_TOKEN).toString()

        val mBundle = Bundle()
        mBundle.putString(EXTRA_TOKEN,token)

       // uploadViewModel = ViewModelProvider(this, ViewModelFactory(UserPreference.getInstance(dataStore), this))[UploadViewModel::class.java]

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        binding.uploadButtonCamera.setOnClickListener {
            startCameraX()
        }
        binding.uploadButtonGallery.setOnClickListener {
            startGallery()
        }

        /*
        binding.uploadButtonUpload.setOnClickListener {
            uploadImage()
        } */
        binding.uploadButtonCancel.setOnClickListener{
            switchToDashboardSistemActivity()
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getMyLastLocation()

        binding.uploadDate.setOnClickListener {
            openDatePicker()
        }
    }

    private fun openDatePicker() {

        textview_date = this.binding.uploadDate
        button_date = this.binding.uploadDateButton

       // textview_date!!.text = "--/--/----"
       textview_date!!.text = resources.getString(R.string.upload_tanggal_image)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@UploadActivity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(this, resources.getString(R.string.camera_permission_error), Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun allPermissionsGranted()= REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun startGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, resources.getString(R.string.choose_picture))
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val myFile = uriToFile(selectedImg, this@UploadActivity)
            getFileImage = myFile
            binding.uploadPreviewImage.setImageURI(selectedImg)
        }
    }

    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = it.data?.getSerializableExtra(resources.getString(R.string.file_picture)) as File
            val isBackCamera = it.data?.getBooleanExtra(resources.getString(R.string.camera_back), true) as Boolean

            getFileImage = myFile
            val result = rotateBitmap(
                BitmapFactory.decodeFile(getFileImage?.path),
                isBackCamera
            )

            binding.uploadPreviewImage.setImageBitmap(result)
        }
    }

    /*
    private fun uploadImage() {
        if (getFileImage != null) {
            val file = reduceFileImage(getFileImage as File)
            val description = binding.uploadInputTextDescription.text.toString().toRequestBody("text/plain".toMediaType())
            val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData("photo", file.name, requestImageFile)
            val lat = currentLocation?.latitude?.toFloat()
            val lon = currentLocation?.longitude?.toFloat()

            val service = ApiConfig.getApiService().postStory("Bearer $token", description, imageMultipart, lat, lon)

            service.enqueue(object : Callback<DataStories> {
                override fun onResponse(
                    call: Call<DataStories>,
                    response: Response<DataStories>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if ((responseBody != null) && !responseBody.error) {
                            Toast.makeText(this, responseBody.message, Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, DashboardSistemActivity::class.java))
                        }
                    } else {
                        Toast.makeText(this, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<DataStories>, t: Throwable) {
                    Toast.makeText(this, resources.getString(R.string.retrofit_instance_failed), Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, resources.getString(R.string.retrofit_failed_image), Toast.LENGTH_SHORT).show()
        }
    } */

    @SuppressLint("MissingPermission")
    private fun getMyLastLocation() {
        if(checkPermission(Manifest.permission.ACCESS_FINE_LOCATION) &&
            checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
        ){
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    currentLocation = location
                } else {
                    Toast.makeText(this, getString(R.string.maps_location_error), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        when {
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false -> {
                getMyLastLocation()
            }
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false -> {
                getMyLastLocation()
            }
        }
    }

    private fun switchToDashboardSistemActivity() {
        intent = Intent(this@UploadActivity, DashboardSistemActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object{
        const val EXTRA_TOKEN = "extra_token"
        const val CAMERA_X_RESULT = 200
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}