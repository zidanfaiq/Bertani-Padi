package com.zidanfaiq.bertanipadi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hama (
    var nama_hama: String,
    var deskripsi_hama: String,
    var gejala_hama: String,
    var pengendalian_hama: String,
    var image_hama: Int
) : Parcelable