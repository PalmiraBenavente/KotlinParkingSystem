package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.mvp.contract.DialogDateResarvationContract
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class DialogDateReservationPresenterTest {
    private lateinit var presenter: DialogDateResarvationContract.DialogFragmentDateReservationPresenter
    private val view: DialogDateResarvationContract.DialogFragmentDateReservationView = mock()

    @Before
    fun setUp() {
        presenter = DialogDateResarvationPresenter(view = view)
    }

    @Test
    fun `on ok button pressed`() {
        presenter.onOkButtonPressed()
        verify(view).dismissPicker()
    }

    @Test
    fun `on cancel button pressed`() {
        presenter.onCancelButtonPressed()
        verify(view).dismissPicker()
    }
}
