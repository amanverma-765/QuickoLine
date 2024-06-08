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
        return booleanDatastoreManager.saveData(data = data, key = key)
    }

    override fun getData(key: String): Flow<ApiResponse<Boolean>> {
        return booleanDatastoreManager.getData(key = key)
    }
}