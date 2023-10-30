package com.caseaplikasi.core.utils.mapper

import com.caseaplikasi.core.data.source.local.entity.PromoEntity
import com.caseaplikasi.core.data.source.remote.response.GetPromoResponseItem
import com.caseaplikasi.core.domain.model.PromoModel

object PromoDataMapper {
    fun mapResponsesToEntities(
        input: List<GetPromoResponseItem>
    ): List<PromoEntity> {
        val promoList = ArrayList<PromoEntity>()
        input.map {
            val promo = PromoEntity(
                id = it.id,
                nama = it.nama,
                desc = it.desc,
                latitude = it.latitude,
                longitude = it.longitude,
                createdAt = it.createdAt,
                lokasi  = it.lokasi,
                image_url  = it.img?.url
            )
            promoList.add(promo)
        }
        return promoList
    }

    fun mapEntitiesToDomain(input: List<PromoEntity>): List<PromoModel> =
        input.map {
            PromoModel(
                id = it.id,
                nama = it.nama,
                desc = it.desc,
                latitude = it.latitude,
                longitude = it.longitude,
                createdAt = it.createdAt,
                lokasi  = it.lokasi,
                image_url  = it.image_url
            )
        }
}