package org.quickoline.repository.supabase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.domain.repository.PublicPostRepository
import org.quickoline.model.remote.mapper.PublicPostDataMapper.toPublicPostData
import org.quickoline.remote.supabase.SupabasePublicDataSource
import org.quickoline.utils.ApiResponse

class PublicPostRepositoryImpl(
    private val supabasePublicDataSource: SupabasePublicDataSource
) : PublicPostRepository {
    override fun fetchFormFillingData(
        searchTrending: Boolean,
        lastMinute: Boolean
    ): Flow<ApiResponse<List<PublicPostData>>> {
        return supabasePublicDataSource.fetchFormFillingData(
            searchTrending = searchTrending,
            lastMinute = lastMinute
        ).map { response ->
            when (response) {
                is ApiResponse.Success -> {
                    val formFillingData = response.data.map { it.toPublicPostData() }
                    ApiResponse.Success(formFillingData)
                }

                is ApiResponse.Error -> ApiResponse.Error(response.message)
                is ApiResponse.Loading -> ApiResponse.Loading
            }
        }
    }

    override fun fetchLegalServiceData(): Flow<ApiResponse<List<PublicPostData>>> {
        return supabasePublicDataSource.fetchLegalServiceData().map { response ->
            when (response) {
                is ApiResponse.Success -> {
                    val legalServiceData = response.data.map { it.toPublicPostData() }
                    ApiResponse.Success(legalServiceData)
                }

                is ApiResponse.Error -> ApiResponse.Error(response.message)
                is ApiResponse.Loading -> ApiResponse.Loading
            }
        }
    }
}