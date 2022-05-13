import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object MergeTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val firstObservable = Observable.interval(10, TimeUnit.MILLISECONDS)
        val secondObservable = Observable.interval(20, TimeUnit.MILLISECONDS)
        val mergedObservable = firstObservable.mergeWith(secondObservable)

        mergedObservable.subscribe { println("Merged observable emitted $it") }
        Thread.sleep(100)
    }
}