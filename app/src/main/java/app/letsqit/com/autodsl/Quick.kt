package app.letsqit.com.autodsl

import android.provider.CalendarContract
import app.letsqit.com.annotations.annotations.AutoDSL
import java.util.*

/**
 * Created by gilgoldzweig on 11/08/2017.
 */
//@AutoDSL
data class Quick(
        var title: String = "event create by Q-IT Enterprise Android App",

        var inviteeList: List<String> = emptyList(),

        var anonymousInviteeList: List<String> = emptyList(),

        var startDate: String = "",

        var timeFrameStart: String = "08:00+03:00",

        var eventDuration: String = "PT0H30M",

        var endDate: String = "",

        var timeFrameEnd: String = "19:30+03:00",

        var optionsNum: Int = 25,


        var initiator: String? = "",


        var timeEventList: List<Any> = emptyList(),


        var irrelevantTimes: List<Date> = emptyList(),


        var evaluationCommands: List<String> = listOf("SPECIAL_LOCATIONS"),

        var listOfUnwantedTimes: List<Any> = emptyList(),

        var overNight: Boolean = true,

        var conferenceRooms: Map<String, List<CalendarContract.CalendarEntity>> = emptyMap(),

        var requestedEventType: String = "WORK",

        var ignoreSettings: List<String> = emptyList())  {

    constructor(quick: Quick.() -> Unit) : this() {
        this.apply(quick)
    }
}