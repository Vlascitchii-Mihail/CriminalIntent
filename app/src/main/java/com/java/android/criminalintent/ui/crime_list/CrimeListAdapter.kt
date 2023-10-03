package com.java.android.criminalintent.ui.crime_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.java.android.criminalintent.data.model.Crime
import com.java.android.criminalintent.databinding.ListItemCrimeBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class CrimeListAdapter(private val onClickCrime: (crimeId: UUID) -> Unit): ListAdapter<Crime, CrimeListAdapter.CrimeHolder>(ListItemCallback()) {

    class ListItemCallback: DiffUtil.ItemCallback<Crime>() {
        override fun areItemsTheSame(oldItem: Crime, newItem: Crime) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Crime, newItem: Crime) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CrimeHolder(inflateListItemCrimeBinding(parent))

    override fun onBindViewHolder(crimeHolder: CrimeHolder, position: Int) {
        crimeHolder.bind(getItem(position))
    }

    inner class CrimeHolder(private val binding: ListItemCrimeBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(crime: Crime) = with(binding) {
            txvCrimeTitle.text = crime.title
            txvCrimeDate.text = getFormattedDate(crime.date)
            imvCrimeSolved.visibility = if (crime.isSolved) View.VISIBLE else View.INVISIBLE
            root.setOnClickListener { onClickCrime.invoke(crime.id) }
        }

        private fun getFormattedDate(date: Date) =
           SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault()).format(date)
    }

    companion object {
        fun inflateListItemCrimeBinding(parent: ViewGroup) =
            ListItemCrimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
}