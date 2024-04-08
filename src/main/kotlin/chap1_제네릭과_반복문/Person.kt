package chap1_제네릭과_반복문

class Person(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val address: Address,
    val hobby: String? = null,
) {
    override fun toString(): String {
        return "Person(id=$id, firstName='$firstName', lastName='$lastName', address='$address', hobby=$hobby)"
    }
}