package org.quickoline.remote.koin

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.serializer.KotlinXSerializer
import io.github.jan.supabase.supabaseJson
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.quickoline.remote.supabase.SupabasePublicDataSource
import org.quickoline.remote.BuildConfig

@OptIn(ExperimentalSerializationApi::class)
val supabaseModule = module {

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