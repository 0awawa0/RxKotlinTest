import io.reactivex.rxjava3.core.Observable

object JustTest {

    private data class MyClass(val item: Int)

    @JvmStatic
    fun main(args: Array<String>) {
        val justObservable = Observable.just(MyClass(1))
        justObservable.subscribe { println(it.item) }
    }
}