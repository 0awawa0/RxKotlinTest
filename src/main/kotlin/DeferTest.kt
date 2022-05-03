import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import java.util.Date

object DeferTest {

    class TestObservable: Observable<Long>() {
        private val time = Date().time

        init { println("Created at $time") }
        override fun subscribeActual(observer: Observer<in Long>) {
            observer.onNext(time)
            observer.onComplete()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val observable1 = TestObservable()
        val observable2 = Observable.defer { TestObservable() }

        observable1.subscribe { }
        Thread.sleep(1000)
        observable2.subscribe { }
    }
}