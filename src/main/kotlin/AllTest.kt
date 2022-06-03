import io.reactivex.rxjava3.core.Observable

object AllTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val sourceObservable = Observable.fromIterable(2..10 step 2)
        val allObservable = sourceObservable.all { it % 2 == 0 }
        allObservable.subscribe(
            {
                println("All observable emitted $it")
            },
            {}
        )
    }
}