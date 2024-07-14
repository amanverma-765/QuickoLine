package org.quickoline.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.quickoline.data.remote.supabase.SupabasePublicDataSource
import org.quickoline.domain.model.post.PostData
import org.quickoline.domain.repository.PostDataRepository
import org.quickoline.data.mapper.PostDataMapper.toPublicPostData
import org.quickoline.utils.ApiResponse

class PostDataRepositoryImpl(
    private val supabasePublicDataSource: SupabasePublicDataSource
) : PostDataRepository {
    override fun fetchFormFillingData(
        searchTrending: Boolean,
        lastMinute: Boolean
    ): Flow<ApiResponse<List<PostData>>> {
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

    override fun fetchLegalServiceData(): Flow<ApiResponse<List<PostData>>> {
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