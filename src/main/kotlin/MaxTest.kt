import hu.akarnokd.rxjava3.math.MathObservable
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

object MaxTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = List(1000) { Random.nextInt() }
        val sourceObservable = Observable.fromIterable(list)
        val maxObservable = MathObservable.max(sourceObservable)
        maxObservable.subscribe {emit ->
            println("Max observable emitted: $emit")
            assert(emit == list.maxOf { it })
        }
    }
}