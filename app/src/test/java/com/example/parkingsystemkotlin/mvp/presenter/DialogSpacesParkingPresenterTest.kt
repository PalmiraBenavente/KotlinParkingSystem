package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.listener.ListenerDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.DialogSpaceParkingContract
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test

class DialogSpacesParkingPresenterTest {
    private lateinit var presenter: DialogSpaceParkingContract.DialogSpaceParkingPresenter
    private val view: DialogSpaceParkingContract.DialogSpaceParkingView = mock()
    private val listener: ListenerDialogFragment = mock()

    @Before
    fun setup() {
        presenter = DialogSpaceParkingPresenter(view = view)
    }

    @Test
    fun `ok button press `() {
        whenever(view.getSpacesFromEditText()).thenReturn(PARKING_LOTS.toString())
        presenter.onSaveButtonPressed(listener)
        verify(listener).setAmountParkingSpaces(PARKING_LOTS)
        verify(view).dismissDialogFragment()
    }

    companion object {
        private const val PARKING_LOTS = 5
    }
}
