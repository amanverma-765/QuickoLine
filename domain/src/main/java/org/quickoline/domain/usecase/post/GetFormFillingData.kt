package org.quickoline.domain.usecase.post

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.domain.repository.PublicPostRepository
import org.quickoline.utils.ApiResponse

class GetFormFillingData(
    private val publicPostRepository: PublicPostRepository
) {
    operator fun invoke(): Flow<ApiResponse<List<PublicPostData>>> {
        return publicPostRepository.fetchFormFillingData()
    }
}