import spark.Response

fun Response.withSuccess(): String {
    this.status(200)
    this.header("content-type", "application/json")

    return "{\"success\" : ${true}}"
}

fun Response.withError(e: Exception): String {
    this.status(401)
    this.header("content-type", "application/json")
    return "{ \"error\" : ${e.localizedMessage} }"
}