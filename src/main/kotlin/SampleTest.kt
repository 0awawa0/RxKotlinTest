import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

object SampleTest {


    @JvmStatic
    fun main(args: Array<String>) {
        // Main observable emits value every millisecond
        val mainObservable = Observable.interval(1, TimeUnit.MILLISECONDS)

        // Sampling observable emits value every 2 milliseconds
        val samplingObservable = Observable.interval(2, TimeUnit.MILLISECONDS)

        // Sampling will look as follows
        // Main observable:     -0-1-2-3-4-5-6-7-8-9->
        //                           |   |   |   |
        //                           V   V   V   V
        // Sampling observable: -0---1---2---3---4--->
        // Sampled observable:  -0---2---4---6---8--->
        val sampledObservable = mainObservable.sample(samplingObservable)

        sampledObservable.subscribe { println("Sampled observable emitted: $it") }
        Thread.sleep(100)
    }
}