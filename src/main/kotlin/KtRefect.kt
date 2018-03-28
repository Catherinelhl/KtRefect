import annotation.PoKo

@PoKo
data class Person(var name:String,var age:Int)

fun main(args: Array<String>) {
    var person=Person("catherine",24)
    println(person)
    var person2=Person::class.java.newInstance()
    println(person2)
}