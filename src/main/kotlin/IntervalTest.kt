import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object IntervalTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val intervalObservable = Observable.interval(1, TimeUnit.SECONDS)
        intervalObservable.subscribe { println("Received value $it") }
        Thread.sleep(5000)
    }
}