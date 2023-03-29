package se.marcusahnve

import kotlin.random.Random

fun joinTwoRandomly(prefixes: List<String>, suffixes: List<String>): String {
	val prefix = randomFromList(prefixes)
	val suffix = randomFromList(suffixes)
	return joinPrefixAndSuffix(prefix, suffix)
}

fun randomFromList(list: List<String>): String {
	val index = Random.nextInt(list.size)
	return list[index]
}

fun joinPrefixAndSuffix(prefix: String, suffix: String): String {
	return "${prefix}${suffix}"
}
