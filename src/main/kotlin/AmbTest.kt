import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

object AmbTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val firstDelay = Random.nextLong(1, 5)
        val secondDelay = Random.nextLong(1, 5)
        println("First delay = $firstDelay, second delay = $secondDelay")
        val firstObservable = Observable.fromIterable(1..3).delay(firstDelay, TimeUnit.MILLISECONDS)
        val secondObservable = Observable.fromIterable(5..10).delay(secondDelay, TimeUnit.MILLISECONDS)
        val ambObservable = firstObservable.ambWith(secondObservable)
        ambObservable.subscribe {
            println("Amb observable emitted $it")
        }
        Thread.sleep(500)
    }
}