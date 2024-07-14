package org.quickoline.dashboard.presentation.viewmodel.post

import org.quickoline.domain.model.post.PostData
import org.quickoline.utils.ApiResponse

internal data class PostUiStates(
    val postResponse: ApiResponse<List<PostData>> = ApiResponse.Loading,
)