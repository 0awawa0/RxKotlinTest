import io.reactivex.rxjava3.core.Observable

object SkipTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3, 4, 5)
        val skippedObservable = mainObservable.skip(2)
        skippedObservable.subscribe { println("Skipped observable emitted $it") }
    }
}