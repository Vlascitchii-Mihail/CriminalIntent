package com.java.android.criminalintent.ui.crime_list

import androidx.lifecycle.ViewModel
import com.java.android.criminalintent.data.model.Crime
import java.util.Date
import java.util.UUID

class CrimeListViewModel: ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            crimes += Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0
            )
        }
    }
}