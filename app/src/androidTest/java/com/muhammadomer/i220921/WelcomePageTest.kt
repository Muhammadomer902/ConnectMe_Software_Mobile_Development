package com.muhammadomer.i220921


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class WelcomePageTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(WelcomePage::class.java)

    @Test
    fun welcomePageTest() {
        pressBack()

        val appCompatButton = onView(
            allOf(
                withId(R.id.myBtn), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.myBtn), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.Registeration), withText("Register"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        10
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.myBtn), withText("Register"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main),
                        0
                    ),
                    10
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        val appCompatButton5 = onView(
            allOf(
                withId(R.id.myBtn), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton5.perform(click())

        val appCompatButton6 = onView(
            allOf(
                withId(R.id.myBtn), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.main),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton6.perform(click())

        val appCompatButton7 = onView(
            allOf(
                withId(R.id.DM),
                childAtPosition(
                    allOf(
                        withId(R.id.CommunityText),
                        childAtPosition(
                            withId(R.id.main),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton7.perform(click())

        val appCompatButton8 = onView(
            allOf(
                withId(R.id.ChatUsername), withText("Henry Benjamin"),
                childAtPosition(
                    allOf(
                        withId(R.id.ChatPerson1),
                        childAtPosition(
                            withId(R.id.DMList),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton8.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
