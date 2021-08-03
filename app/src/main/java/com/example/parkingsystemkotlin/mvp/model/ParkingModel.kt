package com.example.parkingsystemkotlin.mvp.model

import com.example.parkingsystemkotlin.database.ParkingDatabase
import com.example.parkingsystemkotlin.mvp.contract.ParkingContract

class ParkingModel(private val database: ParkingDatabase) : ParkingContract.MainActivityModel {

    override fun setParkingSpace(spaces: Int) {
        database.setParkingLots(spaces)
    }

    override fun getParkingSpace() = database.getParkingLots()
}
