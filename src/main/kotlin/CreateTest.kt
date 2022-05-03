import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

object CreateTest {

    class TestObserver: Observer<Int> {
        override fun onSubscribe(d: Disposable) { println("Subscribed") }
        override fun onError(e: Throwable) { println("Error occurred: ${e.stackTraceToString()}") }
        override fun onComplete() { println("Observing completed") }
        override fun onNext(t: Int) { println("Received value $t") }
    }


    @JvmStatic
    fun main(args: Array<String>) {
        val observable = Observable.unsafeCreate<Int> {
            it.onNext(3)
            it.onComplete()
        }

        val observer = TestObserver()
        observable.subscribeWith(observer)
        println()

        val observable1 = Observable.create<Int> {
            it.onNext(4)
            it.onComplete()
        }

        observable1.subscribe { println("Received value $it") }
    }
}