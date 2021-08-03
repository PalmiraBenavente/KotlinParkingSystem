package com.example.parkingsystemkotlin.mvp.model

import com.example.parkingsystemkotlin.database.ParkingDatabase
import com.example.parkingsystemkotlin.entity.Reservation
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.utils.ReservationChecker
import java.util.Calendar

class ReservationParkingModel(
    private val database: ParkingDatabase,
    private val reservationChecker: ReservationChecker
) : ReservationParkingContract.ReservationActivityModel {
    private var reservation = Reservation()

    override fun getReservation(): Reservation = reservation

    override fun reservationVerify(reservation: Reservation) =
        reservationChecker.checkReservation(reservation)

    override fun addReservation(reservation: Reservation) {
        database.addReservation(reservation)
    }

    override fun setReservationLotCode(parkingLot: Int, parkingCode: Int) {
        reservation.parkingLot = parkingLot
        reservation.userCode = parkingCode
    }

    override fun setStartDate(calendarDateTime: Calendar) {
        reservation.startDate = calendarDateTime
    }

    override fun setEndDate(calendarDateTime: Calendar) {
        reservation.endDate = calendarDateTime
    }
}
