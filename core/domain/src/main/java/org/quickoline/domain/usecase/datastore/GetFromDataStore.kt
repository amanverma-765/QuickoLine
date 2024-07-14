package org.quickoline.domain.usecase.datastore

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.repository.PreferencesDatabaseRepository
import org.quickoline.utils.ApiResponse

class GetFromDataStore(
    private val preferencesDatabaseRepository: PreferencesDatabaseRepository
) {
    operator fun invoke(key: String): Flow<ApiResponse<Boolean>> {
        return preferencesDatabaseRepository.getData(key)
    }
}