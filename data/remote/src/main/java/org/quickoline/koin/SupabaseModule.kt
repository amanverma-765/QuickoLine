package org.quickoline.koin

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.dsl.module
import org.quickoline.remote.supabase.SupabasePublicDataSource

val supabaseModule = module{

    single<SupabaseClient> {
        createSupabaseClient(
            supabaseUrl = "https://dnvmgcfyggzsmmfflbgy.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRudm1nY2Z5Z2d6c21tZmZsYmd5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTU4OTA0ODAsImV4cCI6MjAzMTQ2NjQ4MH0.UKm3OZKHFzRxABe76n7Hu8wkJe6MM_RBeIm97WiTuWU"
        ) {
            install(Postgrest)
        }
    }

    single { SupabasePublicDataSource(supabaseClient = get()) }
}