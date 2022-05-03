import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object TimerTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val timerObservable = Observable.timer(1, TimeUnit.SECONDS)
        timerObservable.subscribe { println("Received value $it") }
        Thread.sleep(2000)
    }
}