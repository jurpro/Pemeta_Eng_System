package com.ujanglukmanbdg.pemeta.data.database.repository

import com.ujanglukmanbdg.pemeta.data.database.model.ModelDatabaseReport
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporan
import com.ujanglukmanbdg.pemeta.data.lapangan.PhotoLaporanItem

object DataMapUser {

    fun mapReportResponseToReportItem(input: List<PhotoLaporan>) : List<ModelDatabaseReport> {
        val listReport = ArrayList<ModelDatabaseReport>()
        input.map {
            val report = ModelDatabaseReport(
                id = it.id,
                name = it.uploadName,
                photo = it.uploadPhoto.toString(),
                job = it.uploadJob,
                location = it.uploadLocation,
                date = it.uploadDate,
                description = it.uploadDescription,
            )
            listReport.add(report)
        }
        return listReport
    }
}