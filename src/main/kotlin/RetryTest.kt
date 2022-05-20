import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import java.util.*

object RetryTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = RandomIntervalObservable(3, 0..1).map { 10 / it }
        val retryObservable = mainObservable.retry()

        retryObservable.subscribe { println("Retry observable emitted $it") }
    }
}