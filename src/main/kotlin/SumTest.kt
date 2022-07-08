import hu.akarnokd.rxjava3.math.MathObservable
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random

object SumTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = List(1000) { Random.nextInt() }
        val sourceObservable = Observable.fromIterable(list)
        val sumObservable = MathObservable.sumInt(sourceObservable)
        sumObservable.subscribe {
            println("Sum observable emitted $it")
            assert(it == list.sum())
        }
    }
}