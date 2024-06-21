package com.example.recreate

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class test {

    @Rule
    @JvmField
    var mActivityScenarioRule=ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun login(){
        onView(withId(R.id.textView))

            .perform(editTexttext("pranat"), closeSoftKeyboard())

        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.textView))
            .check(matches(eithText("pranat")))
    }
}