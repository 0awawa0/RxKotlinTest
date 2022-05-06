import io.reactivex.rxjava3.core.Observable

object BufferTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val bufferObservable = mainObservable.buffer(3)
        val bufferWithSkipObservable = mainObservable.buffer(3, 1)

        mainObservable.subscribe { println("Main observable emitted: $it") }
        bufferObservable.subscribe { println("Buffer observable emitted: $it") }
        bufferWithSkipObservable.subscribe { println("Buffer with skip observable emitted: $it")}
    }
}