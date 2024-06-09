package org.quickoline.dashboard.presentation.viewmodel.post

import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.utils.ApiResponse

internal data class PostUiStates(
    val postResponse: ApiResponse<List<PublicPostData>> = ApiResponse.Loading,
)