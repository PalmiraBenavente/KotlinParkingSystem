package com.example.parkingsystemkotlin.utils

import com.example.parkingsystemkotlin.database.ParkingDatabase
import com.example.parkingsystemkotlin.entity.Reservation

class ReservationChecker(private val dataBase: ParkingDatabase = ParkingDatabase) {

    fun checkReservation(reservation: Reservation): EnumReservationVerify {
        return when {
            reservation.isStarDateInitialized.not() -> EnumReservationVerify.MISSING_DATESTART
            reservation.isEndDateInitialized.not() -> EnumReservationVerify.MISSING_DATEEND
            reservation.parkingLot == Constant.NOT_VALID -> EnumReservationVerify.MISSING_LOT
            reservation.userCode == Constant.NOT_VALID -> EnumReservationVerify.MISSING_CODE
            reservationOK(reservation).not() -> EnumReservationVerify.RESERVATION_OVERLAP
            else -> EnumReservationVerify.COMPROBATION_OK
        }
    }

    private fun reservationOK(reservation: Reservation): Boolean {
        if (dataBase.getHashMapReservation().containsKey(reservation.parkingLot)) {
            val reservationsOnLot: List<Reservation>? = dataBase.getHashMapReservation()[reservation?.parkingLot]
            if (!reservationsOnLot.isNullOrEmpty()) {
                for (reserve in reservationsOnLot) {
                    if (isOverlap(reserve, reservation)) return false
                }
            }
        }
        return true
    }

    private fun isOverlap(reservation: Reservation, reservationAux: Reservation): Boolean {
        val reservationStartDate = reservation.startDate
        val reservationEndDate = reservation.endDate
        val reservationStartDateAux = reservationAux?.startDate
        val reservationEndDateAux = reservationAux?.endDate
        if (reservationStartDate.before(reservationStartDateAux) && reservationEndDate.after(
                reservationStartDateAux
            )
        ) return true
        if (reservationStartDate.before(reservationEndDateAux) && reservationEndDate.after(
                reservationEndDateAux
            )
        ) return true
        return reservationStartDate.after(reservationStartDateAux) && reservationEndDate.before(
            reservationEndDateAux
        )
    }
}
