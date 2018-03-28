import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * 用来测试kotlin和java分别在反射里面所消耗的时间差
 * */

fun main(args: Array<String>) {
    val catherine = cost("Kotlin 构造函数") {
        Person::class.primaryConstructor!!.call("Catherine", 24)
    }
    val catherineJ = cost("java 构造函数") {
        Person::class.java.getDeclaredConstructor(String::class.java, Int::class.java)
                .newInstance("CatherineJ", 25)
    }

    cost("Kotlin 访问属性") {
        Person::class.memberProperties
                .firstOrNull { it.name == "age" }
                ?.get(catherine)
    }
    cost("java 访问属性") {
        Person::class.java.getDeclaredField("age")
                .apply { isAccessible = true }
                .get(catherineJ)
    }


    cost("Kotlin 修改属性") {
        (Person::class.memberProperties.firstOrNull { it.name == "age" } as? KMutableProperty<Int>)
                ?.setter?.call(catherine, 26)
    }
    cost("java 修改属性") {
        Person::class.java.getDeclaredField("age").apply { isAccessible = true }.set(catherineJ, 27)
    }
    cost("Kotlin 访问方法") {
        //        Person::class.memberFunctions.forEach(::print)
        Person::class.memberFunctions.firstOrNull { it.name == "toString" }?.call(catherine)
    }
    cost("java 访问方法") {
        Person::class.java.getMethod("toString").invoke(catherineJ)
    }

}

inline fun <T> cost(tag: String = "", crossinline block: () -> T): T {
    val start = System.nanoTime()
    val t=block()
    println("$tag:${System.nanoTime() - start}")
    return t

}