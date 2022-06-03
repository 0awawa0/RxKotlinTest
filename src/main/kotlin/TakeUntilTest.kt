import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object TakeUntilTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.interval(1, TimeUnit.MILLISECONDS).take(20)
        val triggerObservable = Observable.fromIterable(1..2).delay(10, TimeUnit.MILLISECONDS)
        val takeObservable = sourceObservable.takeUntil(triggerObservable)
        takeObservable.subscribe {
            println("Take observable emitted $it")
        }
        Thread.sleep(100)
    }
}