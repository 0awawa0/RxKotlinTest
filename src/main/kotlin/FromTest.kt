import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.Date
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.concurrent.thread

object FromTest {

    private val executor = Executors.newSingleThreadExecutor()

    private fun getFuture(): Future<Long> {
        return executor.submit<Long> {
            Thread.sleep(1000)
            return@submit Date().time
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arrayObservable = Observable.fromArray(1, 2, 3, 4, 5)
        val futureObservable = Observable.fromFuture(getFuture()).subscribeOn(Schedulers.newThread())
        val iterableObservable = Observable.fromIterable(listOf(5, 4, 3, 2, 1))

        futureObservable.subscribe {
            println("Received value: $it")
            executor.shutdown()
        }
        arrayObservable.subscribe { println("Received value $it") }
        iterableObservable.subscribe { println("Received value: $it") }
    }
}