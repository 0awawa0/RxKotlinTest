import io.reactivex.rxjava3.core.Observable

object CombineLatestTest {

    @JvmStatic
    fun main(args: Array<String>) {

        val firstObservable = RandomEmitObservable(10, 100, 200)
        val secondObservable = RandomEmitObservable(10, 100, 200)

        val combinationObservable = Observable.combineLatest(firstObservable, secondObservable) { first, second -> "$first $second" }
        combinationObservable.subscribe {
            println("Combination observable emitted $it")
        }
    }
}