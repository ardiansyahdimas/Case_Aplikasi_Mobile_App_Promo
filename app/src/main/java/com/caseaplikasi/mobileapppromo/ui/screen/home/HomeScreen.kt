package com.caseaplikasi.mobileapppromo.ui.screen.home

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.caseaplikasi.core.data.Resource
import com.caseaplikasi.core.domain.model.PromoModel
import com.caseaplikasi.mobileapppromo.ui.components.CenteredCircularProgress
import com.caseaplikasi.mobileapppromo.ui.components.PromoItem
import com.caseaplikasi.mobileapppromo.ui.screen.PromoViewModel
import com.google.gson.Gson

@Composable
fun HomeScreen(
    viewModel: PromoViewModel,
    navigateToDetail: (String) -> Unit
) {
    val promoDataState by viewModel.getPromos.collectAsState(initial = Resource.Loading())

    when (promoDataState) {
        is Resource.Loading -> {
            CenteredCircularProgress()
        }
        is Resource.Success<*> -> {
            val data = (promoDataState as Resource.Success).data
            PromoRow(listPromo = data as List<PromoModel>, navigateToDetail = navigateToDetail)
        }
        is Resource.Error -> {
            Text("Error: ${(promoDataState as Resource.Error)}")
        }
        else -> {
            Text("Error: ${(promoDataState as Resource.Error)}")
        }
    }
}




@Composable
fun PromoRow(
    listPromo: List<PromoModel>,
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ){
        items(listPromo, key = { it.id }) { promo ->
            PromoItem(
                promoModel = promo,
                modifier = Modifier
                    .clickable {
                        val json = Uri.encode(Gson().toJson(promo))
                        navigateToDetail(json)
                    }
                    .padding(8.dp)
            )
        }
    }
}