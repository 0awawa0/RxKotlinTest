import io.reactivex.rxjava3.core.Observable

object MapTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..9)
        val mappedObservable = mainObservable.map { it * it }

        mainObservable.subscribe { println("Main observable emitted $it") }
        mappedObservable.subscribe { println("Mapped observable emitted $it") }
    }
}