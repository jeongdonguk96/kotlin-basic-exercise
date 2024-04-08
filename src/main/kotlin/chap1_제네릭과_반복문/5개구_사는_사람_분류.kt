package chap1_제네릭과_반복문

fun main() {
    val people = mutableListOf<Person>()

    val firstNames = listOf("김", "이", "박", "정", "최")
    val lastNames = listOf("민수", "최선", "유리", "민정", "성지")
    val addresses = listOf(Address.DONGJAK, Address.JONGRO, Address.GANGSEO, Address.GURO, Address.GANGNAM)
    val hobbies = listOf("축구", "독서", null, "요리", null)


    for (i in 1..10000) {
        val person = Person(idGenerator(), randomGenerator(firstNames), randomGenerator(lastNames), randomGenerator(addresses), randomGenerator(hobbies))
        people.add(person)
    }

    val dongjakPeople = mutableListOf<Person>()
    val jongroPeople = mutableListOf<Person>()
    val gangseoPeople = mutableListOf<Person>()
    val guroPeople = mutableListOf<Person>()
    val gangnamPeople = mutableListOf<Person>()

    for (person in people) {
        when (person.address) {

            Address.DONGJAK -> dongjakPeople.add(person)
            Address.JONGRO -> jongroPeople.add(person)
            Address.GANGSEO -> gangseoPeople.add(person)
            Address.GURO -> guroPeople.add(person)
            Address.GANGNAM -> gangnamPeople.add(person)
        }
    }

    println("동작구: ${dongjakPeople.size}명, 종로구: ${jongroPeople.size}명, 강서구: ${gangseoPeople.size}명, 구로구: ${guroPeople.size}명, 강남구: ${gangnamPeople.size}명")

}