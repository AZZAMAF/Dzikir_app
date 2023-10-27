package com.idn.doadandzikir.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artikel(
    val imageArtikel: Int,
    val titleArtikel: String,
    val descArtikel: String
) : Parcelable
