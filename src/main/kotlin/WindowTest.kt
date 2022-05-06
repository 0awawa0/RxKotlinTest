import io.reactivex.rxjava3.core.Observable

object WindowTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..9)
        val windowedObservable = mainObservable.window(3)

        windowedObservable.subscribe {window ->
            println("Window opened")
            window.subscribe {
                println("Window emitted $it")
            }
        }
    }
}