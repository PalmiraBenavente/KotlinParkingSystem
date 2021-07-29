package com.example.parkingsystemkotlin.database

import com.example.parkingsystemkotlin.entity.Reservation
import com.example.parkingsystemkotlin.utils.Constant

object ParkingDatabase {
    private val hashMapReservation: HashMap<Int, ArrayList<Reservation>> = HashMap()
    private var parkingLots: Int = Constant.PARKING_LOT_NOT_SET

    fun addReservation(reservation: Reservation) {
        with(reservation.parkingLot) {
            if (hashMapReservation.containsKey(this)) {
                hashMapReservation[this]?.add(reservation)
            } else {
                hashMapReservation.put(this, arrayListOf(reservation))
            }
        }
    }

    fun getHashMapReservation() = hashMapReservation

    fun getParkingLots() = parkingLots

    fun setParkingLots(lots: Int) {
        parkingLots = lots
    }
}
