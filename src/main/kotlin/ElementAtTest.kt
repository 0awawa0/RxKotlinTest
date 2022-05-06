import io.reactivex.rxjava3.core.Observable

object ElementAtTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val mainObservable = Observable.fromArray(1, 2, 3, 4)
        val thirdElem = mainObservable.elementAt(2)
        val fifthElem = mainObservable.elementAt(4)

        thirdElem.subscribe(
            { println("Third elem is $it") },
            { println("Error retrieving third elem")},
            { }
        )

        fifthElem.subscribe(
            { println("Fifth elem is $it") },
            { println("Error retrieving fifth elem") },
            { }
        )
    }
}