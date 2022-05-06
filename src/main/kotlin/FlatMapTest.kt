import io.reactivex.rxjava3.core.Observable

object FlatMapTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val list1 = listOf(1, 2, 3)
        val list2 = listOf(4, 5, 6)
        val list3 = listOf(7, 8, 9)
        val collectedObservable = Observable.fromArray(list1, list2, list3)

        val flatMapObservable = collectedObservable.flatMap { Observable.fromIterable(it) }

        collectedObservable.subscribe { println("collectedObservable emitted $it") }
        flatMapObservable.subscribe { println("flatMapObservable emitted $it") }
    }
}