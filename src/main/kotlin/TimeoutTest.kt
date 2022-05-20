import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object TimeoutTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.defer { RandomEmitObservable(10, 1, 20) }
        val timeoutObservable = mainObservable.timeout(20, TimeUnit.MILLISECONDS)

        timeoutObservable.subscribe(
            { println("Timeout observable emitted $it") },
            { println("Error received $it")}
        )
    }
}