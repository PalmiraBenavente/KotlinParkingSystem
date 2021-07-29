package com.example.parkingsystemkotlin.mvp.contract

import com.example.parkingsystemkotlin.entity.Reservation
import com.example.parkingsystemkotlin.utils.EnumReservationVerify
import java.util.Calendar

interface ReservationParkingContract {

    interface ReservationActivityPresenter {
        fun onButtonStartDatePressedSelectReserver()
        fun onButtonEndDatePressedSelectReserver()
        fun onButtonPressedSaveReserver()
        fun setReservation(calendarDateTime: Calendar, startDate: Boolean)
    }

    interface ReservationActivityView {
        fun showDialogDataPiker(startDatePiker: Boolean)
        fun returnToMainActivity()
        fun getParkingLot(): String
        fun getParkingCode(): String
        fun toastShowFormatError()
        fun toastShowMissingDate()
        fun toastShowMissingLot()
        fun toastShowMissingCode()
        fun toastShowOverlap()
        fun toastShowReserveOK()
        fun toastShowTextData(parkingLot: Int, userCode: Int, startDate: String, endDate: String)
    }

    interface ReservationActivityModel {
        fun setStartDate(calendarDateTime: Calendar)
        fun setEndDate(calendarDateTime: Calendar)
        fun getReservation(): Reservation
        fun reservationVerify(reservation: Reservation): EnumReservationVerify
        fun addReservation(reservation: Reservation)
        fun setReservationLotCode(parkingLot: Int, parkingCode: Int)
    }
}
