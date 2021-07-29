package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.database.ParkingDatabase
import com.example.parkingsystemkotlin.entity.Reservation
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.mvp.model.ReservationParkingModel
import com.example.parkingsystemkotlin.utils.ReservationChecker
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar

class ReservationParkingPresenterTest {
    private lateinit var presenter: ReservationParkingContract.ReservationActivityPresenter
    private val view: ReservationParkingContract.ReservationActivityView = mock()
    private lateinit var model: ReservationParkingContract.ReservationActivityModel

    @Before
    fun setUp() {
        model = ReservationParkingModel(
            database = ParkingDatabase,
            reservationChecker = ReservationChecker()
        )
        presenter = ReservationParkingPresenter(view = view, model = model)
    }

    @Test
    fun `on button start pressed select reservation`() {
        presenter.onButtonStartDatePressedSelectReserver()
        verify(view).showDialogDataPiker(true)
    }

    @Test
    fun `on button end pressed select reservation`() {
        presenter.onButtonEndDatePressedSelectReserver()
        verify(view).showDialogDataPiker(false)
    }

    @Test
    fun `set reservation`() {
        presenter.setReservation(getStartCalendar(), true)
        assertEquals(getStartCalendar(), model.getReservation().startDate)
        presenter.setReservation(getEndCalendar(), false)
        assertEquals(getEndCalendar(), model.getReservation().endDate)
    }

    @Test
    fun ` missing start date`() {
        whenever(view.getParkingLot()).thenReturn(PARKING_LOT.toString())
        whenever(view.getParkingCode()).thenReturn(USER_CODE.toString())
        presenter.onButtonPressedSaveReserver()
        verify(view).toastShowMissingDate()
    }

    @Test
    fun `missing end date`() {
        whenever(view.getParkingLot()).thenReturn(PARKING_LOT.toString())
        whenever(view.getParkingCode()).thenReturn(USER_CODE.toString())
        presenter.setReservation(getEndCalendar(), false)
        assertEquals(getEndCalendar(), model.getReservation().endDate)
        presenter.onButtonPressedSaveReserver()
        verify(view).toastShowMissingDate()
    }

    @Test
    fun `missing parking lot`() {
        whenever(view.getParkingLot()).thenReturn(EMPTY_LOT.toString())
        whenever(view.getParkingCode()).thenReturn(USER_CODE.toString())
        presenter.setReservation(getStartCalendar(), true)
        presenter.setReservation(getEndCalendar(), false)
        assertEquals(getEndCalendar(), model.getReservation().endDate)
        presenter.onButtonPressedSaveReserver()
        verify(view).toastShowMissingLot()
    }

    @Test
    fun `missing code`() {
        whenever(view.getParkingLot()).thenReturn(PARKING_LOT.toString())
        whenever(view.getParkingCode()).thenReturn(EMPTY_STRING)
        presenter.setReservation(getStartCalendar(), true)
        presenter.setReservation(getEndCalendar(), false)
        assertEquals(getEndCalendar(), model.getReservation().endDate)
        presenter.onButtonPressedSaveReserver()
        verify(view).toastShowMissingCode()
    }

    @Test
    fun `overlap reservation`() {
        model.addReservation(getOverlapReservation())
        whenever(view.getParkingLot()).thenReturn(PARKING_LOT.toString())
        whenever(view.getParkingCode()).thenReturn(USER_CODE.toString())
        presenter.setReservation(getStartCalendar(), true)
        presenter.setReservation(getEndCalendar(), false)
        presenter.onButtonPressedSaveReserver()
        verify(view).toastShowOverlap()
    }


    @Test
    fun `on button save reservation`() {
        whenever(view.getParkingLot()).thenReturn(PARKING_LOT.toString())
        whenever(view.getParkingCode()).thenReturn(USER_CODE.toString())
        presenter.setReservation(getStartCalendar(), true)
        presenter.setReservation(getEndCalendar(), false)
        presenter.onButtonPressedSaveReserver()
        verify(view).toastShowReserveOK()
        val reservation = model.getReservation()
        assertEquals(getStartCalendar(), reservation.startDate)
        assertEquals(getEndCalendar(), reservation.endDate)
        assertEquals(PARKING_LOT, reservation.parkingLot)
        assertEquals(USER_CODE, reservation.userCode)
        verify(view).toastShowTextData(
            PARKING_LOT,
            USER_CODE,
            getStringDate(getStartCalendar()),
            getStringDate(getEndCalendar())
        )
    }

    private fun getStringDate(calendar: Calendar): String {
        val date = calendar.time
        val simpleDateFormat = SimpleDateFormat(FORMAT_DATE)
        var dateToString: String = EMPTY_STRING
        try {
            dateToString = simpleDateFormat.format(date)
        } catch (e1: Exception) {
            e1.printStackTrace()
            verify(view).toastShowFormatError()
        }
        return dateToString
    }

    private fun getStartCalendar(): Calendar = Calendar.getInstance().apply {
        set(YEAR, MONTH, DAY_START, HOUR, MINUTE, ZERO)
        set(Calendar.MILLISECOND, ZERO)
    }

    private fun getEndCalendar(): Calendar = Calendar.getInstance().apply {
        set(YEAR, MONTH, DAY_END, HOUR, MINUTE, ZERO)
        set(Calendar.MILLISECOND, ZERO)
    }

    private fun getOverlapReservation(): Reservation {
        val reservation = Reservation()
        val startDate = getStartCalendar()
        startDate.set(Calendar.DAY_OF_MONTH, END_DAY_START_OVERLAP)
        reservation.startDate = startDate
        val endDate = getEndCalendar()
        endDate.set(Calendar.DAY_OF_MONTH, END_DAY_OVERLAP)
        reservation.endDate = endDate
        reservation.parkingLot = PARKING_LOT
        reservation.userCode = USER_CODE
        return reservation
    }

    companion object {
        private const val YEAR = 2021
        private const val MONTH = 6
        private const val DAY_START = 9
        private const val DAY_END = 16
        private const val HOUR = 11
        private const val MINUTE = 11
        private const val ZERO = 0
        private const val PARKING_LOT = 5
        private const val USER_CODE = 123
        private const val EMPTY_STRING = ""
        private const val FORMAT_DATE = "hh: mm a dd-MMM-yyyy"
        private const val EMPTY_LOT = -1
        private const val END_DAY_OVERLAP = 15
        private const val END_DAY_START_OVERLAP = 8
    }
}
