import io.reactivex.rxjava3.core.Observable

object TimeIntervalTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.defer { RandomEmitObservable(10, 2, 10) }
        val intervalObservable = mainObservable.timeInterval()

        intervalObservable.subscribe {
            println("Time from previous emit $it")
        }
    }
}