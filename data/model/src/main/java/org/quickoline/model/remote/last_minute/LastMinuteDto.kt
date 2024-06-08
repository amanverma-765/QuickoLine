package org.quickoline.model.remote.last_minute


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LastMinuteDtoItem(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("post")
    val post: String
)