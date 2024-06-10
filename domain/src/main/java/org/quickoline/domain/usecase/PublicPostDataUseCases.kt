package org.quickoline.domain.usecase

import org.quickoline.domain.usecase.post.GetFormFillingData
import org.quickoline.domain.usecase.post.GetLastMinuteData
import org.quickoline.domain.usecase.post.GetLegalServiceData
import org.quickoline.domain.usecase.post.GetTrendingData

data class PublicPostDataUseCases(
    val getFormFillingData: GetFormFillingData,
    val getLastMinuteData: GetLastMinuteData,
    val getLegalServiceData: GetLegalServiceData,
    val getTrendingData: GetTrendingData
)