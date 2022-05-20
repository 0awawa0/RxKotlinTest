import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executors

object ObserveOnTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..9)
        val changedObservable = mainObservable.observeOn(Schedulers.newThread())

        val mainThread = Thread.currentThread()
        println("Is main thread equal to itself: ${mainThread == Thread.currentThread()}")
        changedObservable.subscribe {
            println("Changed observable emitted $it. Observed on the main thread: ${mainThread == Thread.currentThread()}")
        }
    }
}