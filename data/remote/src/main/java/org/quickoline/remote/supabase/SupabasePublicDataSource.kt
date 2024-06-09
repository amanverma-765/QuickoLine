package org.quickoline.remote.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.quickoline.model.remote.dto.post.LastMinuteDto
import org.quickoline.model.remote.dto.post.PublicPostDto
import org.quickoline.utils.ApiResponse

class SupabasePublicDataSource(private val supabaseClient: SupabaseClient) {

    fun fetchFormFillingData(): Flow<ApiResponse<List<PublicPostDto>>> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val res = supabaseClient.postgrest["form_filling"].select()
                val data = res.decodeList<PublicPostDto>()
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.message))
            }
        }
    }

    fun fetchLegalServiceData(): Flow<ApiResponse<List<PublicPostDto>>> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val res = supabaseClient.postgrest["legal_service"].select()
                val data = res.decodeList<PublicPostDto>()
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.message))
            }
        }
    }

    fun fetchLastMinuteData(): Flow<ApiResponse<List<PublicPostDto>>> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val lastMinRes = supabaseClient.postgrest["last_minute"].select()
                val lastMinData = lastMinRes.decodeList<LastMinuteDto>()

                val publicPostDataList = mutableListOf<PublicPostDto>()

                for (lastMinute in lastMinData) {
                    val res = supabaseClient.postgrest["form_filling"].select {
                        filter { eq("id", lastMinute.postId) }
                    }
                    val formData = res.decodeList<PublicPostDto>()
                    publicPostDataList.addAll(formData)
                }
                emit(ApiResponse.Success(publicPostDataList))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.message))
            }
        }
    }
}