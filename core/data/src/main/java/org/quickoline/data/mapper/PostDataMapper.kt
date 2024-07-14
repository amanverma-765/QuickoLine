package org.quickoline.data.mapper


import org.quickoline.data.model.dto.FeesDto
import org.quickoline.data.model.dto.PostDataDto
import org.quickoline.domain.model.post.FeesData
import org.quickoline.domain.model.post.PostData


object PostDataMapper {

    fun PostDataDto.toPublicPostData() : PostData {
        return PostData(
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