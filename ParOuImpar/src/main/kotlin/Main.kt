fun calc(numbers: List<Int>){

    for (item in numbers) {
        if (item % 2 == 0) {
            println("$item - Par")
        } else {
            println("$item - Impar")
        }
    }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    calc(numbers)
}