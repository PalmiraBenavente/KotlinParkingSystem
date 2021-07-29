package com.example.parkingsystemkotlin.utils

enum class EnumReservationVerify {
    MISSING_DATESTART,
    MISSING_DATEEND,
    MISSING_LOT,
    MISSING_CODE,
    COMPROBATION_OK,
    RESERVATION_OVERLAP
}
