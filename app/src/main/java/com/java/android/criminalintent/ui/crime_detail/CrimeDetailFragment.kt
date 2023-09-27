package com.java.android.criminalintent.ui.crime_detail

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.java.android.criminalintent.BaseFragment
import com.java.android.criminalintent.data.model.Crime
import com.java.android.criminalintent.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID

class CrimeDetailFragment: BaseFragment<FragmentCrimeDetailBinding>(FragmentCrimeDetailBinding::inflate)  {

    private lateinit var crime: Crime

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() = with(binding) {
        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )

        inputCrimeTitle.doOnTextChanged { text, _, _, _ ->
            crime = crime.copy(title = text.toString())
        }

        btnCrimeDate.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        chbCrimeSolved.setOnCheckedChangeListener {_, isChecked ->
            crime = crime.copy(isSolved = isChecked)
        }
    }
}