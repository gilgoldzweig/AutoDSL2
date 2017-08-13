package app.letsqit.com.autodsl

import com.goldzweigapps.dsl.LocationFinderDSL
import com.goldzweigapps.dsl.locationFinder
import org.junit.Test
import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println(locationFinder<String, Int, Boolean>(4.6, "Testttt", {a, b, c ->

        }) {
            placesList = listOf("one", "two", "three")
            placesSet = setOf(1, 2, 3)
            placesMap = mapOf("key1".to(2).to(false.to(2)))
            onClick("a", 2, false)
        })
//        val randomInt = Random().nextInt(24 * 11).toString()
//        val finder =  locationFinder(4.6) {
//            iditGoldzweig {
//                name = "Idit Goldzweig"
//                vectorImagePath = "UP UP DOWN DOWN RIGHT RIGHT LEFT LEFT"
//            }
//            placeName = randomInt
//            latitude = 24.22
//        }
//        finder.printIditLocation()
//        assertEquals(finder, locationFinder(4.6) {
//            iditGoldzweig {
//                name = "Idit Goldzweig"
//                vectorImagePath = "UP UP DOWN DOWN RIGHT RIGHT LEFT LEFT"
//            }
//            placeName = randomInt
//            latitude = 24.22
//        })

//        println(finder)
    }
}
