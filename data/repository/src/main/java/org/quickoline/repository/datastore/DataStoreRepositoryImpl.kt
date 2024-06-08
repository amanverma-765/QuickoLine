package org.quickoline.repository.datastore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import org.quickoline.domain.repository.DataStoreRepository
import org.quickoline.local.datastore.BooleanDataStoreManager
import org.quickoline.utils.ApiResponse

class DataStoreRepositoryImpl(
    private val booleanDatastoreManager: BooleanDataStoreManager
) : DataStoreRepository {
    override suspend fun saveData(data: Boolean?, key: String): Flow<ApiResponse<Unit>> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                booleanDatastoreManager.saveData(data = data, key = key)
                emit(ApiResponse.Success(Unit))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.message))
            }
        }
    }

    override fun getData(key: String): Flow<ApiResponse<Boolean>> {
        return flow {
            emit(ApiResponse.Loading)
            try {
                val dataStore = booleanDatastoreManager.getData(key)
                dataStore.collect { data ->
                    emit(ApiResponse.Success(data))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResponse.Error(e.message))
            }
        }
    }
}