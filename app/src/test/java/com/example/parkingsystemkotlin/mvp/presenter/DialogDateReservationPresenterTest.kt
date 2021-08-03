package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.listener.ListenerDialogFragmentDate
import com.example.parkingsystemkotlin.mvp.contract.DialogDateReservationContract
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import java.util.Calendar

class DialogDateReservationPresenterTest {
    private lateinit var presenter: DialogDateReservationContract.DialogFragmentDateReservationPresenter
    private val view: DialogDateReservationContract.DialogFragmentDateReservationView = mock()
    private val listener: ListenerDialogFragmentDate = mock()

    @Before
    fun setUp() {
        presenter = DialogDateReservationPresenter(view = view, startDatePicker = true)
    }

    @Test
    fun `on ok button pressed save start date`() {
        whenever(view.getYear()).thenReturn(YEAR)
        whenever(view.getMonth()).thenReturn(MONTH)
        whenever(view.getDay()).thenReturn(DAY)
        whenever(view.getHour()).thenReturn(HOUR)
        whenever(view.getMinute()).thenReturn(MINUTE)

        presenter.onOkButtonPressed(listener)

        verify(view).setDateTime(listener, true, getCalendar())
        verify(view).dismissPicker()
    }

    @Test
    fun `on cancel button pressed`() {
        presenter.onCancelButtonPressed()
        verify(view).dismissPicker()
    }

    private fun getCalendar(): Calendar = Calendar.getInstance().apply {
        set(YEAR, MONTH, DAY, HOUR, MINUTE, ZERO)
        set(Calendar.MILLISECOND, ZERO)
    }


    companion object {
        private const val YEAR = 2021
        private const val MONTH = 6
        private const val DAY = 9
        private const val HOUR = 11
        private const val MINUTE = 11
        private const val ZERO = 0
    }
}
