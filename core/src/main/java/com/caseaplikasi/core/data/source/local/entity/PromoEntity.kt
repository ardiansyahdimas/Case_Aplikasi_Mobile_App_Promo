package com.caseaplikasi.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "promo", indices = [androidx.room.Index(value = ["id"], unique = true)])
data class PromoEntity(
    @PrimaryKey
    @Nonnull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "nama")
    var nama: String?,

    @ColumnInfo(name = "desc")
    var desc: String?,

    @ColumnInfo(name = "latitude")
    var latitude: String?,

    @ColumnInfo(name = "longitude")
    var longitude: String?,

    @ColumnInfo(name = "createdAt")
    var createdAt: String?,

    @ColumnInfo(name = "lokasi")
    var lokasi  : String?,

    @ColumnInfo(name = "image_url")
    var image_url  : String?
)