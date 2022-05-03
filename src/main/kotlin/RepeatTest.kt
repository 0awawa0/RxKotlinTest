import io.reactivex.rxjava3.core.Observable

object RepeatTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val repeatObservable = Observable.fromIterable(listOf(1, 2, 3)).repeat(3)
        repeatObservable.subscribe { println("Received item $it") }
    }
}