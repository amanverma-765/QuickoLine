package org.quickoline.dashboard.presentation.viewmodel.home

import org.quickoline.domain.model.post.PostData
import org.quickoline.utils.ApiResponse

internal data class HomeUiStates(
    val trendingResponse: ApiResponse<List<PostData>> = ApiResponse.Loading
)