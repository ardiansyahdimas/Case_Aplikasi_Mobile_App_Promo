package com.caseaplikasi.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromoModel(
    var id: Int,
    var nama: String?,
    var desc: String?,
    var latitude: String?,
    var longitude: String?,
    var createdAt: String?,
    var lokasi  : String?,
    var image_url  : String?
): Parcelable