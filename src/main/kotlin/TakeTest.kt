import io.reactivex.rxjava3.core.Observable

object TakeTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3, 4, 5)
        val takeObservable = mainObservable.take(2)
        takeObservable.subscribe { println("Emitted $it") }
    }
}