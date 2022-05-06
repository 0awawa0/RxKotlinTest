import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.random.Random

object DebounceTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val periodicObservable = Observable.defer { RandomEmitObservable(1000, 1, 15) }
        val debouncedObservable = periodicObservable.debounce(10L, TimeUnit.MILLISECONDS)

        var periodicCounter = 0
        var debouncedCounter = 0
        periodicObservable.subscribe(
            { periodicCounter++ },
            {},
            { println("Periodic observable emitted $periodicCounter times") }
        )

        debouncedObservable.subscribe(
            { debouncedCounter++ },
            {},
            { println("Debounced observable emitted $debouncedCounter times") }
        )
    }
}