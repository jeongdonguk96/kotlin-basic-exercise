package chap1_제네릭과_반복문

import kotlin.random.Random

fun main() {
    val people = mutableListOf<Person>()

    val firstNames = listOf("김", "이", "박", "정", "최")
    val lastNames = listOf("민수", "최선", "유리", "민정", "성지")
    val addresses = listOf(Address.DONGJAK, Address.JONGRO, Address.GANGSEO, Address.GURO, Address.GANGNAM)
    val hobbies = listOf("축구", "독서", null, "요리", null)

    for (i in 1..10) {
        val person = Person(idGenerator(), randomGenerator(firstNames), randomGenerator(lastNames), randomGenerator(addresses), randomGenerator(hobbies))
        people.add(person)
    }

    println("총 인원 수: ${people.size}")

    for (person in people) {
        println(person)
    }

    val guroPeople = people
        .filter { it.address == Address.GURO }
        .map { it.firstName + it.lastName }

    println("구로에 사는 사람들: $guroPeople")
}

var i = 0L
fun idGenerator(): Long {
    i++

    return i
}


fun <T> randomGenerator(items: List<T>): T {
    val randomIndex = Random.nextInt(items.size)
    return items[randomIndex]
}

