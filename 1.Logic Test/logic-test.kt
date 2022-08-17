fun main() {
    val list1 = listOf(1, 3, 5, 7, 9)
    val list2 = listOf(3, 6, 8, 1, 5, 10, 1, 7)
    val list3 = listOf(-5, 5, 6)
    val list4 = listOf(1)
    val list5 = listOf<Int>()
    println(findMiddleIndex(list1))
    println(findMiddleIndex(list2))
    println(findMiddleIndex(list3))
    println(findMiddleIndex(list4))
    println(findMiddleIndex(list5))

    println(isPalindrome("aka"))
    println(isPalindrome("kayak"))
    println(isPalindrome("hello"))
    println(isPalindrome("helloh"))
    println(isPalindrome(""))
    println(isPalindrome("1"))
}

/*
1. Please write a function to find the index that has the sum of left’s elements equal to the sum of right’s elements .

Example 1: input => [1, 3, 5, 7, 9] output => “middle index is 3”
Example 2: input => [3, 6, 8, 1, 5, 10, 1, 7] output => “middle index is 4”
Example 3: input => [3, 5, 6] output => “index not found”
 */

fun findMiddleIndex(list: List<Int>): String {
    var sum = 0
    for (i in list) {
        sum += i
    }
    var leftSum = 0
    for (i in 0 until list.size) {
        if (leftSum == sum - leftSum - list[i]) {
            return "middle index is $i with value ${list[i]}"
        }
        leftSum += list[i]
    }
    return "index not found"
}

/*
2. Please write a function to detect that incoming string is palindrome or not
Example 1: input => “aka”, output => “aka is a palindrome”
Example 2: input => “Level”, output => “Level is a palindrome”
Example 3: input => “Hello”, output => “Hello isn’t a palindrome”
Note: Please use only the basic programming function like if-else, loop, etc.
 */

fun isPalindrome(str: String): String {
   for (i in 0 until str.length / 2) {
       if (str[i] != str[str.length - 1 - i]) {
           return "$str isn't a palindrome"
       } 
   }
   return "$str is a palindrome"
}
