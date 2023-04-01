package se.marcusahnve

import io.kotest.core.spec.style.ExpectSpec
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.kotest.shouldHaveBody
import org.http4k.kotest.shouldHaveStatus

class SkidskytteRouletteTest: ExpectSpec({

	context("an app with just one prefix and one suffix") {
		val prefixes = listOf<String>("prefix")
		val suffixes = listOf<String>("suffix")
		val app = createApp(prefixes, suffixes)
		val response = app(Request(Method.GET, "/random"))
		response.shouldHaveStatus(Status.OK)
		response.shouldHaveBody("prefixsuffix")
	}
})
