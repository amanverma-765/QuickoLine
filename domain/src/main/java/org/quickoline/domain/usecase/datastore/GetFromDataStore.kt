package org.quickoline.domain.usecase.datastore

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.repository.DataStoreRepository
import org.quickoline.utils.ApiResponse

class GetFromDataStore(
    private val dataStoreRepository: DataStoreRepository
) {
    operator fun invoke(key: String): Flow<ApiResponse<Boolean>> {
        return dataStoreRepository.getData(key)
    }
}