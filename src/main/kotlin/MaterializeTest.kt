import io.reactivex.rxjava3.core.Observable

object MaterializeTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..3)
        val materializedObservable = mainObservable.materialize()

        val dematerializedObservable = materializedObservable.dematerialize { it }

        materializedObservable.subscribe { println("Materialized observable emitted $it") }
        dematerializedObservable.subscribe { println("Dematerialized observable emitted $it") }
    }
}