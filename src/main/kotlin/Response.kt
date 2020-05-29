import com.fasterxml.jackson.databind.JsonNode
import spark.Response

fun Response.withSuccess(): String {
    this.status(200)
    this.header("content-type", "application/json")

    return "{\"success\" : ${true}}"
}

fun Response.withJsonString(jsonString: String): String {
    val status = if (jsonString.isEmpty()) 204 else 200
    this.status(status);
    this.header("content-type", "application/json")
    return jsonString
}

fun Response.withJson(json: JsonNode): String {
    this.status(200)
    this.header("content-type", "application/json")
    return json.toPrettyString()
}

fun Response.withError(e: Exception): String {
    this.status(401)
    this.header("content-type", "application/json")
    return "{ \"error\" : ${e.localizedMessage} }"
}