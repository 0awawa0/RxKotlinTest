import io.reactivex.rxjava3.core.Observable

object DefaultIfEmptyTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.fromIterable<Int>(emptyList())
        val defaultObservable = sourceObservable.defaultIfEmpty(1)
        defaultObservable.subscribe { println("Default observable emitted $it") }
    }
}