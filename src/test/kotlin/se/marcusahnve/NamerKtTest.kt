package se.marcusahnve

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class NamerKtTest : ExpectSpec({

	expect("join prefix and suffix without any connector") {
		joinTwoRandomly(listOf("first"), listOf("second")).shouldBe("firstsecond")
	}

})
