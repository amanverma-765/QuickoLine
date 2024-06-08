package org.quickoline.model.remote.legal_service


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LegalServiceDto(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("docs_required")
    val docsRequired: List<String>,
    @SerialName("fees")
    val fees: Int,
    @SerialName("id")
    val id: String,
    @SerialName("service_charge")
    val serviceCharge: Int,
    @SerialName("title")
    val title: String
)