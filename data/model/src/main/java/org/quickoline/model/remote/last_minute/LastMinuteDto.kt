package org.quickoline.model.remote.last_minute


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LastMinuteDto(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("id")
    val id: String,
    @SerialName("post_id")
    val postId: String
)