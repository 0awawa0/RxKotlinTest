import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import java.util.*

class RandomIntervalObservable(val count: Int, val interval: IntRange): Observable<Int>() {

    private val observers = LinkedList<Observer<in Int>>()

    override fun subscribeActual(observer: Observer<in Int>) {
        repeat(count) {
            try {
                observer.onNext(interval.random())
            } catch (ex: Exception) {
                println("Caught error $ex")
                return@repeat
            }
        }
    }
}