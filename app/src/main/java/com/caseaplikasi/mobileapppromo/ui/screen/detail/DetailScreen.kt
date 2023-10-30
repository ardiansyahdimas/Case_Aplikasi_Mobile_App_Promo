package com.caseaplikasi.mobileapppromo.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.caseaplikasi.core.domain.model.PromoModel
import com.caseaplikasi.mobileapppromo.ui.components.SectionText


@Composable
fun DetailScreen(
    promo: PromoModel,
    navigateBack: () -> Unit,
) {
    DetailContent(promo = promo, onBackClick = navigateBack)
}


@Composable
fun DetailContent(
    promo:PromoModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {


    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(promo.image_url),
                    contentDescription = null,
                    contentScale = Fit,
                    modifier = modifier.height(400.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp).clickable { onBackClick() }
                )
            }
            Column(modifier = Modifier.padding(top = 10.dp,start = 20.dp, end = 20.dp)) {
                Text(
                    text = promo.nama.toString(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                SectionText(title = "Tanggal", content = promo.createdAt.toString())
                SectionText(title = "Lokasi", content = promo.lokasi.toString())
                SectionText(title = "Deskripsi", content = promo.desc.toString())
            }
        }
    }
}