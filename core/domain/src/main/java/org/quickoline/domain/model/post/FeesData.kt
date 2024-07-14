package org.quickoline.domain.model.post

import kotlinx.serialization.Serializable


@Serializable
data class FeesData(
    val all: Int?,
    val ews: Int?,
    val fem: Int?,
    val gen: Int?,
    val obc: Int?,
    val ph: Int?,
    val sc: Int?,
    val st: Int?
) {
    fun toList(): List<Pair<String, Int?>> {
        return listOfNotNull(
            all?.let { "All Category" to it },
            ews?.let { "EWS" to it },
            fem?.let { "Female" to it },
            gen?.let { "General" to it },
            obc?.let { "OBC" to it },
            ph?.let { "PH" to it },
            sc?.let { "SC" to it },
            st?.let { "ST" to it }
        )
    }
}