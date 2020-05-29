package models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GiphyEntity(
    val id: String,
    val url: String,
    val slug: String,
    val username: String,
    val images: Map<String, GiphyImageEntity>
)