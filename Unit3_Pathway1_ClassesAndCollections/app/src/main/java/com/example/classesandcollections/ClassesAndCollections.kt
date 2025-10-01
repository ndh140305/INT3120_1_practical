package com.example.classesandcollections

import kotlin.compareTo

//t1
data class Event(
    val title: String,
    val description: String,
    val daypart: Daypart,
    val durationInMinutes: Int)

//t2
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, description = "Time to get up", durationInMinutes = 15)
val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, description = "Time to get up", durationInMinutes = 30)
val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, description = "Time to get up",durationInMinutes = 60)
val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, description = "Time to get up",durationInMinutes = 10)
val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, description = "Time to get up",durationInMinutes = 45)

//t3
val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

//t4
val shortEvents = events.filter { it.durationInMinutes < 60 }

//t5
val groupedEvents = events.groupBy { it.daypart }

//t7
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${com.example.classesandcollections.events.size} events")
    }

    //t6

    println("Last event of day: ${events.last().title}")


}
