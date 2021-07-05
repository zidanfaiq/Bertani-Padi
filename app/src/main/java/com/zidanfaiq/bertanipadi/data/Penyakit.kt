package com.zidanfaiq.bertanipadi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Penyakit (
    var nama_penyakit: String,
    var deskripsi_penyakit: String,
    var gejala_penyakit: String,
    var pengendalian_penyakit: String,
    var image_penyakit: Int
) : Parcelable