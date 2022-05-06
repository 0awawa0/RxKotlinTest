import io.reactivex.rxjava3.core.Observable

object FirstTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(3, 2, 1)
        val firstObservable = mainObservable.first(-1)
        println("First elem is ${firstObservable.blockingGet()}")
    }
}