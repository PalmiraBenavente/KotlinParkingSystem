package com.example.parkingsystemkotlin.mvp.model

import com.example.parkingsystemkotlin.mvp.contract.ParkingContract
import com.example.parkingsystemkotlin.utils.Constant

class ParkingModel() : ParkingContract.MainActivityModel {

    private var parkingLots: Int = Constant.PARKING_LOT_NOT_SET

    override fun setParkingSpace(spaces: Int) {
        parkingLots = spaces
    }

    override fun getParkingSpace(): Int = parkingLots
}
