import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.rybalkinsd.kohttp.dsl.httpGet
import io.github.rybalkinsd.kohttp.ext.asJson
import models.GiphyResponseAPIEntity
import utils.Configuration

class GiphyService {

    private val apiKey = Configuration.giphyApiKey()

    fun fetchGifs(): GiphyResponseAPIEntity {
        val node =  makeGetRequest()
        return jacksonObjectMapper().convertValue(node)
    }

    private fun makeGetRequest(): JsonNode {
        httpGet {
            scheme = "https"
            host = "api.giphy.com"
            path = "/v1/gifs/search"

            header {
                "Content-Type" to "application/json"
            }

            param {
                "api_key" to apiKey
                "q" to "washing hands"
                "limit" to "25"
                "offset" to "0"
                "rating" to "G"
                "lang" to "en"
            }

        }.use {
            return if (it.isSuccessful) {
                it.asJson()
            } else {
                throw Exception(it.message())
            }
        }
    }

}