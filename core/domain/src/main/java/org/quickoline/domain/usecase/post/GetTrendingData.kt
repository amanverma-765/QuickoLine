package org.quickoline.domain.usecase.post

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.model.post.PostData
import org.quickoline.domain.repository.PostDataRepository
import org.quickoline.utils.ApiResponse

class GetTrendingData(
    private val postDataRepository: PostDataRepository
) {
    operator fun invoke(): Flow<ApiResponse<List<PostData>>> {
        return postDataRepository.fetchFormFillingData(
            searchTrending = true,
            lastMinute = false
        )
    }
}