import io.reactivex.rxjava3.core.Observable

object StartWithTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstObservable = Observable.fromArray(1, 2, 3)
        val secondObservable = Observable.fromArray(6, 5, 4)
        val combinedObservable = firstObservable.startWith(secondObservable)

        combinedObservable.subscribe { println("Combined observable emitted $it") }
    }
}