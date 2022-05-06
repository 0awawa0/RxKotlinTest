import io.reactivex.rxjava3.core.Observable

object ScanTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val startSequence = Observable.fromIterable(1..9)
        val factorial = startSequence.scan { t1, t2 -> t1 * t2 }
        factorial.subscribe { println("Factorial sequence sequence emitted $it") }
    }
}