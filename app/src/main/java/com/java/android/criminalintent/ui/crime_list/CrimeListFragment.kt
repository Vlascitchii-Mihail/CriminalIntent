package com.java.android.criminalintent.ui.crime_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.java.android.criminalintent.BaseFragment
import com.java.android.criminalintent.R
import com.java.android.criminalintent.databinding.FragmentCrimeListBinding

class CrimeListFragment :
    BaseFragment<FragmentCrimeListBinding>(FragmentCrimeListBinding::inflate) {

    private val crimeListViewModel: CrimeListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.crimeRecyclerView) {
            addItemDecoration(createDecoration())
            this.layoutManager = LinearLayoutManager(context)
            adapter = createCrimeListAdapter()
        }
    }

    private fun createCrimeListAdapter(): CrimeListAdapter {
        val adapter = CrimeListAdapter { id ->
            //TODO: Navigate to the CrimeDetails Fragment
            Toast.makeText(requireContext(), "The crime with $id was clicked", Toast.LENGTH_SHORT)
                .show()
        }
        adapter.submitList(crimeListViewModel.crimes)

        return adapter
    }

    private fun createDecoration() = DividerItemDecoration(context, RecyclerView.VERTICAL).apply {
//            it is also possible
//            setDrawable(
//            requireNotNull(
//            ResourcesCompat.getDrawable(resources, R.drawable.rv_divider_decoration, context?.theme)))
        setDrawable(
            requireNotNull(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.rv_divider_decoration
                )
            )
        )
    }
}
