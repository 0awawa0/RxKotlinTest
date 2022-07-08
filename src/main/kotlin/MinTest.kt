import hu.akarnokd.rxjava3.math.MathObservable
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

object MinTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = List(1000) { Random.nextInt() }
        val sourceObservable = Observable.fromIterable(list)
        val minObservable = MathObservable.min(sourceObservable)
        minObservable.subscribe { emit ->
            println("Min observable emitted $emit")
            assert(emit == list.minOf { it })
        }
    }
}