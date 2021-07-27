package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.mvp.contract.ParkingContract
import com.example.parkingsystemkotlin.mvp.model.ParkingModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ParkingPresenterTest {
    private lateinit var presenter: ParkingContract.MainActivityPresenter
    private var model: ParkingContract.MainActivityModel = ParkingModel()
    private val view: ParkingContract.MainActivityView = mock()

    @Before
    fun setUp() {
        presenter = ParkingPresenter(model = model, view = view)
    }

    @Test
    fun `set parking button pressed`() {
        presenter.onSelectParkingButtonPressed()
        verify(view).showSelectionParkingSpaces()
    }

    @Test
    fun `set spaces parking`() {
        presenter.onSetParkingButtonPressed(PARKING_SPACES)
        assertEquals(PARKING_SPACES, model.getParkingSpace())
        verify(view).toastShowSpaces(model.getParkingSpace())
    }

    @Test
    fun `set reservation button pressed`() {
        presenter.onBookParkingSpaces()
    }

    companion object {
        private const val PARKING_SPACES: Int = 5
    }
}
