package se.marcusahnve

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer
import java.io.File


fun createApp(prefixes: List<String>, suffixes: List<String>): HttpHandler {
    return routes(
    "/random" bind GET to {
        Response(OK).body(joinTwoRandomly(prefixes, suffixes))
    })
}

fun main() {
	val	prefixes = File(ClassLoader.getSystemResource("prefixes.txt").file).readLines()
	val	suffixes = File(ClassLoader.getSystemResource("suffixes.txt").file).readLines()
    val printingApp: HttpHandler = PrintRequest().then(createApp(prefixes, suffixes))
    val server = printingApp.asServer(Undertow(9000)).start()
    println("Server started on " + server.port())
}
