import hu.akarnokd.rxjava3.math.MathObservable
import io.reactivex.rxjava3.core.Observable

object AverageTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val observable = Observable.fromArray(1, 2, 3, 4, 5)
        val averageObservable = MathObservable.averageDouble(observable)
        averageObservable.subscribe {
            println("Average observable emitted: $it")
        }
    }
}