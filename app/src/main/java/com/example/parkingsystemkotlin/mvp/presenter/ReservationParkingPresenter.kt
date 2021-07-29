package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.entity.Reservation
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.utils.Constant
import com.example.parkingsystemkotlin.utils.EnumReservationVerify
import java.text.SimpleDateFormat
import java.util.Calendar

class ReservationParkingPresenter(
    private val view: ReservationParkingContract.ReservationActivityView,
    private val model: ReservationParkingContract.ReservationActivityModel
) :
    ReservationParkingContract.ReservationActivityPresenter {

    override fun onButtonStartDatePressedSelectReserver() {
        view.showDialogDataPiker(true)
    }

    override fun onButtonEndDatePressedSelectReserver() {
        view.showDialogDataPiker(false)
    }

    override fun onButtonPressedSaveReserver() {
        model.setReservationLotCode(
            getIntegerUserData(view.getParkingLot()),
            getIntegerUserData(view.getParkingCode())
        )
        val reservation: Reservation = model.getReservation()
        when (model.reservationVerify(reservation)) {
            EnumReservationVerify.MISSING_DATESTART -> view.toastShowMissingDate()
            EnumReservationVerify.MISSING_DATEEND -> view.toastShowMissingDate()
            EnumReservationVerify.MISSING_LOT -> view.toastShowMissingLot()
            EnumReservationVerify.MISSING_CODE -> view.toastShowMissingCode()
            EnumReservationVerify.RESERVATION_OVERLAP -> view.toastShowOverlap()
            EnumReservationVerify.COMPROBATION_OK -> {
                view.toastShowReserveOK()
                model.addReservation(reservation)
                view.toastShowTextData(
                    reservation.parkingLot,
                    reservation.userCode,
                    getStringDate(reservation.startDate),
                    getStringDate(reservation.endDate)
                )
                view.returnToMainActivity()
            }
        }
    }

    override fun setReservation(calendarDateTime: Calendar, startDate: Boolean) {
        if (startDate) {
            model.setStartDate(calendarDateTime)
        }
        model.setEndDate(calendarDateTime)
    }

    private fun getStringDate(calendar: Calendar?): String {
        val date = calendar?.time
        val simpleDateFormat = SimpleDateFormat(Constant.FORMAT_DATE)
        var dateToString: String = Constant.EMPTY_STRING
        try {
            dateToString = simpleDateFormat.format(date)
        } catch (exceptionCalendar: Exception) {
            exceptionCalendar.printStackTrace()
            view.toastShowFormatError()
        }
        return dateToString
    }

    private fun getIntegerUserData(userData: String): Int = if (userData.isEmpty()) {
        Constant.NOT_VALID
    } else userData.toInt()
}
