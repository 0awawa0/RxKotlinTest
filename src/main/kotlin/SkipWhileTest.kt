import io.reactivex.rxjava3.core.Observable

object SkipWhileTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.fromIterable(1..20)
        val skipObservable = sourceObservable.skipWhile { it < 10 }
        skipObservable.subscribe {
            println("Skip observable emitted $it")
        }
    }
}