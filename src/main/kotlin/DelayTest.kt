import io.reactivex.rxjava3.core.Observable
import java.util.Date
import java.util.concurrent.TimeUnit

object DelayTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3)
        val delayedObservable = mainObservable.delay(1000, TimeUnit.MILLISECONDS)


        delayedObservable.subscribe {
            println("Delayed observable emitted $it at ${Date().time}")
        }
        println("Subscribed at ${Date().time}")
        Thread.sleep(2000)
    }
}