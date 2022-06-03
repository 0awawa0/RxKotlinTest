import io.reactivex.rxjava3.core.Observable

object ContainsTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.fromIterable(1..10)
        val containsObservable = sourceObservable.contains(3)
        println("Contains observable emitted ${containsObservable.blockingGet()}")
    }
}