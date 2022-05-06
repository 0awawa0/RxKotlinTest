import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import java.util.*
import kotlin.concurrent.thread
import kotlin.random.Random

class RandomEmitObservable(emits: Int, minInterval: Long, maxInterval: Long): Observable<Int>() {
    private val observers = LinkedList<Observer<in Int>>()

    init {
        thread {
            var counter = 0
            while(true) {
                counter++
                observers.forEach { it.onNext(counter) }
                Thread.sleep(Random.nextLong(minInterval, maxInterval))
                if (counter == emits) break
            }
            observers.forEach { it.onComplete() }
        }
    }

    override fun subscribeActual(observer: Observer<in Int>) {  observers.add(observer) }


}