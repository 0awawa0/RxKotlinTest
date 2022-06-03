import io.reactivex.rxjava3.core.Observable

object TakeWhileTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.fromIterable(1..20)
        val takeObservable = sourceObservable.takeWhile { it < 10 }
        takeObservable.subscribe {
            println("Take observable emitted $it")
        }
    }
}