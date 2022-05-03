import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

object EmptyTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val emptyObservable = Observable.empty<Int>()
        val neverObservable = Observable.never<Int>()
        val throwObservable = Observable.error<Int>(Throwable("This is a throw observable"))

        println("Subscribing to emptyObservable")
        emptyObservable.subscribe(
            { println("Received value $it") },
            { println("Received an error: ${it.message}") },
            { println("Observing completed") }
        )
        println()

        println("Subscribing to neverObservable")
        neverObservable.subscribe(
            { println("Received value $it") },
            { println("Received an error: ${it.message}") },
            { println("Observing completed") }
        )
        println()

        println("Subscribing to throwObservable")
        throwObservable.subscribe(
            { println("Received value $it") },
            { println("Received an error: ${it.message}") },
            { println("Observing completed") }
        )
        println()
    }
}