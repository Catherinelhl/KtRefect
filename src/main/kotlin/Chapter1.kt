fun main(args: Array<String>) {
    var str = ""
    str.let {
        println("iam let up")
        println(it)
        println(it.length)
        println("iam let down")
    }.run {
        println(this)
        }

    println("--------------------")
    var nullAbleStr: String? = null

    nullAbleStr?.let {
        println("nullAbleStr let up")
        println(it)
        println(it.length)
        println("nullAbleStr let down")
    }.run {
        println(this)
        }
}