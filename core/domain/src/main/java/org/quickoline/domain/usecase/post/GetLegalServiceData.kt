package org.quickoline.domain.usecase.post

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.model.post.PostData
import org.quickoline.domain.repository.PostDataRepository
import org.quickoline.utils.ApiResponse

class GetLegalServiceData(
    private val publicPostRepository: PostDataRepository
) {
    operator fun invoke(): Flow<ApiResponse<List<PostData>>> {
        return publicPostRepository.fetchLegalServiceData()
    }
}