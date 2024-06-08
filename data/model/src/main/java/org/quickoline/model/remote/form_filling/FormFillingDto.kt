package org.quickoline.model.remote.form_filling


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FormFillingDto(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("docs_required")
    val docsRequired: List<String>,
    @SerialName("fees")
    val fees: FeesDto,
    @SerialName("id")
    val id: String,
    @SerialName("last_date")
    val lastDate: String?,
    @SerialName("post_name")
    val postName: String,
    @SerialName("post_url")
    val postUrl: String,
    @SerialName("service_charge")
    val serviceCharge: Int,
    @SerialName("short_info")
    val shortInfo: String,
    @SerialName("src_url")
    val srcUrl: String,
    @SerialName("start_date")
    val startDate: String?,
    @SerialName("title")
    val title: String,
    @SerialName("trending")
    val trending: Boolean
)