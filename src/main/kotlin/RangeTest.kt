import io.reactivex.rxjava3.core.Observable

object RangeTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val rangeObservable = Observable.range(17, 3)
        rangeObservable.subscribe { println("Received value $it") }
    }
}