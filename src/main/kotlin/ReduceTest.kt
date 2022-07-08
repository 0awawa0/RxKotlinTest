import hu.akarnokd.rxjava3.math.MathObservable
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

object ReduceTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = List(1000) { Random.nextInt() }
        val sourceObservable = Observable.fromIterable(list)
        val reduceObservable = sourceObservable.reduce(0) { acc, curr -> acc + curr }
        reduceObservable.subscribe { emit ->
            println("Reduce observable emitted $emit")
            assert(emit == list.fold(0) { acc, curr -> acc + curr })
        }
    }
}