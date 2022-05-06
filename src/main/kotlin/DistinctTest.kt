import io.reactivex.rxjava3.core.Observable

object DistinctTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 1, 2, 3, 3, 4, 5)
        val distinctObservable = mainObservable.distinct()
        distinctObservable.subscribe { println("Distinct observable emitted $it") }
    }
}