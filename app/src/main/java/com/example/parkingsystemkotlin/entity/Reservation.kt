package com.example.parkingsystemkotlin.entity

import com.example.parkingsystemkotlin.utils.Constant
import java.util.Calendar

class Reservation {
    lateinit var startDate: Calendar
    lateinit var endDate: Calendar
    var parkingLot: Int = Constant.PARKING_LOT_NOT_SET
    var userCode: Int = Constant.PARKING_CODE_NOT_SET
    val isStarDateInitialized get() = this::startDate.isInitialized
    val isEndDateInitialized get() = this::startDate.isInitialized
}
