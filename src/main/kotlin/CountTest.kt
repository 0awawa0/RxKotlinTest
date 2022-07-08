import io.reactivex.rxjava3.core.Observable

object CountTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.fromArray(1, 2, 3, 4, 5, 6, 7)
        val countObservable = sourceObservable.count()
        println("Count observable emitted ${countObservable.blockingGet()}")
    }
}