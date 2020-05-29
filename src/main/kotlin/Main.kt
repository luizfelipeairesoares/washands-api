import spark.Spark.*

fun main(argz: Array<String>) {

    val port = System.getenv("PORT")?.toInt() ?: 4567

    port(port)

    //region Ping
    get("/ping") { request, response ->
        try {
            response.withSuccess()
        } catch (e: Exception) {
            response.withError(e)
        }
    }
    //endregion

    get("/gifs") { request, response ->
        try {
            val gifs = GiphyService().fetchGifs()
            response.withJsonString(JsonTransformer().render(gifs))
        } catch (e: Exception) {
            response.withError(e)
        }
    }

}
