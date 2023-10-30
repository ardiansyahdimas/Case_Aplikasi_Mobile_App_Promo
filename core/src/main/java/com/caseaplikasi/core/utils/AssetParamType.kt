package com.caseaplikasi.core.utils

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.caseaplikasi.core.domain.model.PromoModel
import com.google.gson.Gson

class AssetParamType : NavType<PromoModel>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): PromoModel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, PromoModel::class.java)
        } else {
           bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): PromoModel {
        return Gson().fromJson(value, PromoModel::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: PromoModel) {
        bundle.putParcelable(key, value)
    }
}