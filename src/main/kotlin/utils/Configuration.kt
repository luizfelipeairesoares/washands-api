package utils

import java.io.FileInputStream
import java.util.*

object Configuration {

    private val properties: Properties

    init {
        properties = Properties()
        val propertiesFile = "src/main/resources/configuration.properties"
        val inputStream = FileInputStream(propertiesFile)
        properties.load(inputStream)
    }

    fun giphyApiKey(): String {
        return properties.getProperty("giphy_api_key")
    }

}