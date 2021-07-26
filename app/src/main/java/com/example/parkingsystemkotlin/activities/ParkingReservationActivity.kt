package com.example.parkingsystemkotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parkingsystemkotlin.databinding.ActivityReserverParkingLotBinding
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.mvp.presenter.ReservationParkingPresenter
import com.example.parkingsystemkotlin.mvp.view.ReservationParkingView

class ParkingReservationActivity : AppCompatActivity() {
    private lateinit var presenter: ReservationParkingContract.ReservationActivityPresenter
    private lateinit var binding: ActivityReserverParkingLotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReserverParkingLotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ReservationParkingPresenter(view = ReservationParkingView(this, binding))
        this.setListener()
    }

    private fun setListener() {
        binding.buttonReserverParkingPickerInic.setOnClickListener { presenter.onButtonStartDatePressedSelectReserver() }
        binding.buttonReserverParkingPickerEnd.setOnClickListener { presenter.onButtonEndDatePressedSelectReserver() }
        binding.buttonReserverParkingSave.setOnClickListener { presenter.onButtonPressedSaveReserver() }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ParkingReservationActivity::class.java)
        }
    }
}
