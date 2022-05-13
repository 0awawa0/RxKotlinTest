import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.switchOnNext
import java.util.concurrent.TimeUnit

object SwitchTest {

    @JvmStatic
    fun main(args: Array<String>) {
        // Emits items 1, 2, 3 with 4 millisecond interval between them
        val firstObservable = Observable.interval(4, TimeUnit.MILLISECONDS).zipWith(Observable.fromArray(1, 2, 3)) { _, second -> second }

        // Emits items 4, 5, 6 with 4 millisecond interval between them
        val secondObservable = Observable.interval(4, TimeUnit.MILLISECONDS).zipWith(Observable.fromArray(4, 5, 6)) { _, second -> second }

        // Emits firstObservable and after 9 milliseconds emits second observable
        // By the time secondObservable is emitted, firstObservable should emit items 1 and 2 which will take 8 milliseconds
        // After that secondObservable will emit items 4, 5, and 6
        val switchedObservable = Observable.fromArray(firstObservable, secondObservable).zipWith(Observable.interval(9, TimeUnit.MILLISECONDS)) { first, second -> first }.switchOnNext()
        switchedObservable.subscribe { println("Switched observable emitted $it")}
        Thread.sleep(100)
    }
}