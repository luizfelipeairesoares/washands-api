package models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GiphyResponseAPIEntity(
        val data: List<GiphyEntity>
)