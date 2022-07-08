import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins

object Playground {

    private fun getNamedScheduler(name: String): Scheduler = RxJavaPlugins.createNewThreadScheduler { Thread(it, name) }

    @JvmStatic
    fun main(args: Array<String>) {

        Thread.currentThread().name = "MainThread"

        Observable.just("String") { println("Current thread: 1 ${Thread.currentThread()}") }
            .map { println("Current thread: 2 ${Thread.currentThread()}") }
            .observeOn(getNamedScheduler("New scheduler 1"))
            .map { println("Current thread: 3 ${Thread.currentThread()}") }
            .subscribeOn(getNamedScheduler("New scheduler 2"))
            .subscribeOn(getNamedScheduler("New scheduler 3"))
            .map { println("Current thread: 4 ${Thread.currentThread()}") }
            .subscribe()
    }
}