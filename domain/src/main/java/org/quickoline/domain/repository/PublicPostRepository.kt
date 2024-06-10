package org.quickoline.domain.repository

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.utils.ApiResponse


interface PublicPostRepository {
    fun fetchFormFillingData(searchTrending: Boolean, lastMinute: Boolean): Flow<ApiResponse<List<PublicPostData>>>
    fun fetchLegalServiceData(): Flow<ApiResponse<List<PublicPostData>>>
}