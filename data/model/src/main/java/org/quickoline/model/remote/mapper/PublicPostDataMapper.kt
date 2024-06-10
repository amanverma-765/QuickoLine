package org.quickoline.model.remote.mapper


import org.quickoline.domain.model.post.FeesData
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.model.remote.dto.post.FeesDto
import org.quickoline.model.remote.dto.post.PublicPostDto

object PublicPostDataMapper {

    fun PublicPostDto.toPublicPostData() : PublicPostData {
        return PublicPostData(
            id = id,
            createdAt = createdAt,
            docsRequired = docsRequired,
            lastDate = lastDate,
            postName = postName,
            postUrl = postUrl,
            srcUrl = srcUrl,
            serviceCharge = serviceCharge,
            startDate = startDate,
            shortInfo = shortInfo,
            title = title,
            trending = trending,
            lastMinute = lastMinute,
            fees = fees.toFeesData()
        )
    }
    
    private fun FeesDto.toFeesData(): FeesData {
        return FeesData(
            all = all,
            ews = ews,
            gen = gen,
            obc = obc,
            sc = sc,
            ph = ph,
            fem = fem,
            st = st
        )
    }
}