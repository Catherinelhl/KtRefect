import annotation.PoKo

@PoKo
data class Person(var name:String,var age:Int)

fun main(args: Array<String>) {
    var person=Person("catherine",24)
    println(person)
    var person2=Person::class.java.newInstance()
    println(person2)
//    person2.name=""
    var name=person2.name
//    println(name.isEmpty())
//    println(name.length)
    println(name)

    /**
     * ""和null的区别：这里的let拦截的null对象
     * */
    name.let {
        //        if(it.isEmpty()) return else println(it.length)

        println("iam $it")
        println(it.length)
    }
}