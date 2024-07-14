package org.quickoline.data.repository

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.repository.PreferencesDatabaseRepository
import org.quickoline.data.local.datastore.DataStoreManager
import org.quickoline.utils.ApiResponse

class DataStoreRepositoryImpl(
    private val datastoreManager: DataStoreManager
) : PreferencesDatabaseRepository {
    override suspend fun saveData(data: Boolean?, key: String): Flow<ApiResponse<Unit>> {
        return datastoreManager.saveData(data = data, key = key)
    }

    override fun getData(key: String): Flow<ApiResponse<Boolean>> {
        return datastoreManager.getData(key = key)
    }
}