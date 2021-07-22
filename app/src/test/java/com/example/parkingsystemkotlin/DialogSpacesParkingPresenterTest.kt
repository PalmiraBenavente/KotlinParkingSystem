package com.example.parkingsystemkotlin

import com.example.parkingsystemkotlin.listener.ListenerDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.DialogSpaceParkingContract
import com.example.parkingsystemkotlin.mvp.presenter.DialogSpaceParkingPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

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
        val number = Integer.valueOf(view.getSpacesFromEditText())
        Mockito.verify(listener).setAmountParkingSpaces(number)
        Mockito.verify(view).dismissDialogFragment()
    }

    companion object {
        private const val PARKING_LOTS = 5
    }
}
