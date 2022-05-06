import io.reactivex.rxjava3.core.Observable

object FilterTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..9)
        val filteredObservable = mainObservable.filter { it % 3 == 0 }
        filteredObservable.subscribe { println("Filtered observable emitted $it" ) }
    }
}