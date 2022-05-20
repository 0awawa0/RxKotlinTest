import io.reactivex.rxjava3.core.Observable

object CatchTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3, 0, 4).map { 100 / it }
        val catchObservable = mainObservable.onErrorResumeNext {
            println("Caught error $it")
            Observable.fromArray(0, 1, 2)
        }
        val catchObservable1 = mainObservable.onErrorReturnItem(0)
        catchObservable.subscribe {
            println("Catch observable emitted $it")
        }

        catchObservable1.subscribe {
            println("Catch observable 1 emitted $it")
        }
    }
}