package org.quickoline.data.koin


import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.serializer.KotlinXSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.quickoline.data.BuildConfig
import org.quickoline.data.remote.supabase.SupabasePublicDataSource

@OptIn(ExperimentalSerializationApi::class)
val remoteDatabaseModule = module {

    single<SupabaseClient> {
        createSupabaseClient(
            supabaseUrl = BuildConfig.supabaseUrl,
            supabaseKey = BuildConfig.supabaseApiKey
        ) {
            defaultSerializer = KotlinXSerializer(
                Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                }
            )
            install(Postgrest)
        }
    }

    single { SupabasePublicDataSource(supabaseClient = get()) }
}