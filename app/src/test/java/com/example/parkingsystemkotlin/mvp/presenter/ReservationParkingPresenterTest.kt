package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class ReservationParkingPresenterTest {
    private lateinit var presenter: ReservationParkingContract.ReservationActivityPresenter
    private val view: ReservationParkingContract.ReservationActivityView = mock()

    @Before
    fun setUp() {
        presenter = ReservationParkingPresenter(view = view)
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
    fun `on button save reservation`() {
        presenter.onButtonPressedSaveReserver()
        verify(view).returnToMainActivity()
    }
}
