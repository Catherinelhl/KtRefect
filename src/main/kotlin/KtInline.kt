import java.util.concurrent.locks.Lock

/**
 *
5：inline:内联函数，这里也有noinline，crossinline


6：reified :具象化
 * */
fun main(args: Array<String>) {
    var str = ""
    println(str.test())
    //.joinToString("\n")
    println(memberOf<StringBuilder>())
//    println(memberOf2<String>(1))
    println(lockTest(1) {
        foo<String>()
    })

}

inline fun <T> T.test(): String {
    println(this)
    return "iam $this"
}

inline fun <reified T> memberOf() = T::class.members

inline fun <T> lockTest(lock: Int, block: () -> T): T {
    return block()
}

inline fun <reified T> foo(): Int {
    return 1
}


fun <T> test2(args:T){}
