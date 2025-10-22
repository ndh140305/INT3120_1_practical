package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.InventoryDatabase

class BusScheduleApplication: Application() {
    val database: InventoryDatabase by lazy { InventoryDatabase.getDatabase(this) }
}