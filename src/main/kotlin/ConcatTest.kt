import io.reactivex.rxjava3.core.Observable

object ConcatTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstObservable = Observable.fromArray(5, 6, 7, 8)
        val secondObservable = Observable.fromArray(1, 2, 3, 4)
        val concatObservable = firstObservable.concatWith(secondObservable)
        concatObservable.subscribe {
            println("Concat observable emitted: $it")
        }

        val concatMapObservable = firstObservable.concatMap { secondObservable }
        concatObservable.subscribe {
            println("ConcatMap observable emitted: $it")
        }
    }
}