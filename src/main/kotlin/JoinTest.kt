import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object JoinTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstObservable = Observable.interval(10, TimeUnit.MILLISECONDS)
        val secondObservable = Observable.interval(20, TimeUnit.MILLISECONDS)
        val combinationObservable = firstObservable.join(
            secondObservable,
            { Observable.timer(10, TimeUnit.MILLISECONDS)},
            { Observable.timer(10, TimeUnit.MILLISECONDS)},
            { first, second -> "$first $second" }
        )

        combinationObservable.subscribe { println("Combination observable emitted $it") }
        Thread.sleep(100)
    }
}