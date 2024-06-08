package org.quickoline.domain.repository

import kotlinx.coroutines.flow.Flow
import org.quickoline.utils.ApiResponse

interface DataStoreRepository {
    suspend fun saveData(data: Boolean?, key: String): Flow<ApiResponse<Unit>>
    fun getData(key: String): Flow<ApiResponse<Boolean>>

}