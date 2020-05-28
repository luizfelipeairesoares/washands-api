import spark.Spark

fun main(argz: Array<String>) {

    val port = System.getenv("PORT")?.toInt() ?: 4567

    Spark.port(port)

    Spark.staticFiles.location("/public")

    //region Ping
    Spark.get("/ping") { request, response ->
        try {
            response.withSuccess()
        } catch (e: Exception) {
            response.withError(e)
        }
    }
    //endregion

}