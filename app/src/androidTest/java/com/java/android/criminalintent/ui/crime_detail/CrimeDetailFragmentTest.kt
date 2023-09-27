package com.java.android.criminalintent.ui.crime_detail

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.java.android.criminalintent.R
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setup() {
//        scenario = launchFragment()

        //launch and connect the fragment to the container
        scenario = launchFragmentInContainer()
    }

    @Test
    fun inputTitleEditTextOnLaunch() {
        onView(withId(R.id.input_crime_title))
            .check(matches(withHint(R.string.crime_title_hint)))
    }

    @Test
    fun showDateButtonOnLaunch() {
        onView(withId(R.id.btn_crime_date)).check(matches(not(isEnabled())))
    }

    @Test
    fun showSolvedCheckboxOnLaunch() {
        onView(withId(R.id.chb_crime_solved))
    }

    @After
    fun tearDown() = scenario.close()
}