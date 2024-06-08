package org.quickoline.koin

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.dsl.module
import org.quickoline.remote.supabase.SupabasePublicDataSource
import org.quickoline.remote.BuildConfig

val supabaseModule = module{

    single<SupabaseClient> {
        createSupabaseClient(
            supabaseUrl = BuildConfig.supabaseUrl,
            supabaseKey = BuildConfig.supabaseApiKey
        ) {
            install(Postgrest)
        }
    }

    single { SupabasePublicDataSource(supabaseClient = get()) }
}