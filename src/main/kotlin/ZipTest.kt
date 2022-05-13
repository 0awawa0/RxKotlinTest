import io.reactivex.rxjava3.core.Observable

object ZipTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstObservable = Observable.fromArray(1, 2, 3)
        val secondObservable = Observable.fromArray('a', 'b', 'c', 'd')

        val zippedObservable = firstObservable.zipWith(secondObservable) { first, second -> "$first$second"}
        zippedObservable.subscribe { println("Zipped observable emitted $it") }
    }
}