package com.zidanfaiq.bertanipadi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Budidaya (
    var nama: String,
    var deskripsi: String,
    var image: Int
) : Parcelable