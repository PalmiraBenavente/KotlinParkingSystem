package com.example.parkingsystemkotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parkingsystemkotlin.database.ParkingDatabase
import com.example.parkingsystemkotlin.databinding.ActivityReserverParkingLotBinding
import com.example.parkingsystemkotlin.listener.ListenerDialogFragmentDate
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.mvp.model.ReservationParkingModel
import com.example.parkingsystemkotlin.mvp.presenter.ReservationParkingPresenter
import com.example.parkingsystemkotlin.mvp.view.ReservationParkingView
import com.example.parkingsystemkotlin.utils.ReservationChecker
import java.util.Calendar

class ParkingReservationActivity : AppCompatActivity(), ListenerDialogFragmentDate {
    private lateinit var presenter: ReservationParkingContract.ReservationActivityPresenter
    private lateinit var binding: ActivityReserverParkingLotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReserverParkingLotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ReservationParkingPresenter(
            view = ReservationParkingView(this, binding),
            model = ReservationParkingModel(
                database = ParkingDatabase,
                reservationChecker = ReservationChecker()
            )
        )
        this.setListener()
    }

    private fun setListener() {
        binding.buttonReserverParkingPickerInic.setOnClickListener { presenter.onButtonStartDatePressedSelectReserver() }
        binding.buttonReserverParkingPickerEnd.setOnClickListener { presenter.onButtonEndDatePressedSelectReserver() }
        binding.buttonReserverParkingSave.setOnClickListener { presenter.onButtonPressedSaveReserver() }
    }

    override fun setDateTime(calendarDateTime: Calendar, startDate: Boolean) {
        presenter.setReservation(calendarDateTime, startDate)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ParkingReservationActivity::class.java)
        }
    }
}
