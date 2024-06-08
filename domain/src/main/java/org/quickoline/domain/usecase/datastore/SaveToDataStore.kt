package org.quickoline.domain.usecase.datastore

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.repository.DataStoreRepository
import org.quickoline.utils.ApiResponse

class SaveToDataStore(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(data: Boolean?, key: String): Flow<ApiResponse<Unit>> {
        return dataStoreRepository.saveData(data = data, key = key)
    }
}