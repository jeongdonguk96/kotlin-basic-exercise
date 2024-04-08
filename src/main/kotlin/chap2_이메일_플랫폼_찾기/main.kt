package chap2_이메일_플랫폼_찾기

// 아래의 이메일 목록 중
// 이메일 도메인에 따라
// 어느 도메인에서 들어온 사람인지 구분하라
fun main() {

    val emailList = listOf(
        "abc@gmail.com",
        "asd@daum.com",
        "qwe@kakao.com",
        "123@facebook.com",
        "456@naver.com",
        "789@gmail.com",
        "000@naver.com",
    )

    val result = execute(emailList)
    println(result)
}

// 도메인과 그 도메인을 이용하는 사용자의 수를 맵에 담는다.
fun execute(emailList: List<String>): Map<String, Int> {
    val emailMap = mutableMapOf<String, Int>()
    val atSymbol = "@"
    val dotSymbol = "."

    // 이메일 List를 반복하여
    // 도메인만을 추출한 후
    // Map에 담는다.
    for (list in emailList) {
        val domain = list
            .split(atSymbol)[1]
            .split(dotSymbol)[0]

        emailMap[domain] = emailMap.getOrDefault(domain, 0) + 1
    }

    // Map에 담긴 데이터를 value의 크기로 정렬한다. (List 반환)
    val sortedList = emailMap.entries.sortedByDescending { it.value }

    // 정렬된 List를 Map으로 변환한다.
    val sortedEmailMap = LinkedHashMap<String, Int>()
    for (entry in sortedList) {
        sortedEmailMap[entry.key] = entry.value
    }

    return sortedEmailMap
}