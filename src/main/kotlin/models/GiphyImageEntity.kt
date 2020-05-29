package models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GiphyImageEntity(
        val height: String?,
        val mp4: String?
)