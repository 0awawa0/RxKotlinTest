import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.GroupedObservable
import java.util.*

object GroupByTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromIterable(1..9)
        val groupedObservable = mainObservable.groupBy { if (it % 2 == 1) "Odd" else "Even" }
        val groups = LinkedList<GroupedObservable<String, Int>>()

        groupedObservable.subscribe { group ->
            println("Grouped observable emitted new group with key ${group.key}")
            groups.add(group)
        }

        groups.forEach {group ->
            group.subscribe { println("Group ${group.key} emitted $it") }
        }

        println()

        groupedObservable.subscribe { group ->
            println("Grouped observable emitted new group with key ${group.key}")
            group.subscribe { println("Group ${group.key} emitted $it") }
        }
    }
}