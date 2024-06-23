package org.quickoline.remote.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.quickoline.model.remote.dto.post.PublicPostDto
import org.quickoline.utils.ApiResponse

class SupabasePublicDataSource(private val supabaseClient: SupabaseClient) {

    fun fetchFormFillingData(searchTrending: Boolean, lastMinute: Boolean): Flow<ApiResponse<List<PublicPostDto>>> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val res = supabaseClient.postgrest["form_filling"].select() {
                    if (searchTrending) filter {
                        PublicPostDto::trending eq true
                    }
                    if (lastMinute) filter {
                        PublicPostDto::lastMinute eq true
                    }
                }
                val data = res.decodeList<PublicPostDto>()
                emit(ApiResponse.Success(data))

            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error("Error in fetching data!"))
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
                emit(ApiResponse.Error("Error in fetching data!"))
            }
        }
    }
}