import io.reactivex.rxjava3.core.Observable

object SkipLastTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3, 4, 5)
        val skippedObservable = mainObservable.skipLast(2)
        skippedObservable.subscribe { println("Skipped observable emitted $it") }
    }
}