package org.quickoline.domain.model.post

data class PublicPostData(
    val createdAt: String,
    val docsRequired: List<String>?,
    val fees: FeesData,
    val id: String,
    val lastDate: String?,
    val postName: String?,
    val postUrl: String?,
    val serviceCharge: Int?,
    val shortInfo: String?,
    val srcUrl: String?,
    val startDate: String?,
    val title: String,
    val trending: Boolean,
    val lastMinute: Boolean
)