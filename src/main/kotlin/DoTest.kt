import io.reactivex.rxjava3.core.Observable

object DoTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..3)
        val doObservable = mainObservable.doAfterNext { println("${it * 10}") }
        doObservable.subscribe {
            println("Do observable emitted $it")
        }
    }
}