package org.quickoline.domain.repository

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.model.post.PostData
import org.quickoline.utils.ApiResponse


interface PostDataRepository {
    fun fetchFormFillingData(searchTrending: Boolean, lastMinute: Boolean): Flow<ApiResponse<List<PostData>>>
    fun fetchLegalServiceData(): Flow<ApiResponse<List<PostData>>>
}