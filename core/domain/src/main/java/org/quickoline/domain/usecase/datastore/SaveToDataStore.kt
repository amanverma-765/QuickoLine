package org.quickoline.domain.usecase.datastore

import kotlinx.coroutines.flow.Flow
import org.quickoline.domain.repository.PreferencesDatabaseRepository
import org.quickoline.utils.ApiResponse

class SaveToDataStore(
    private val preferencesDatabaseRepository: PreferencesDatabaseRepository
) {
    suspend operator fun invoke(data: Boolean?, key: String): Flow<ApiResponse<Unit>> {
        return preferencesDatabaseRepository.saveData(data = data, key = key)
    }
}