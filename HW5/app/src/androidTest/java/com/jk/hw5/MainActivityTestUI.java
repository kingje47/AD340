package com.jk.hw5;


import android.support.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import org.junit.Rule;
import org.junit.Test;


//UI testing class designed from https://developer.android.com/training/testing/ui-testing/espresso-testing#java

@LargeTest
public class MainActivityTestUI {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void TestRedFireDragon() {

        onView(withId(R.id.magic_text_box)).perform(typeText("fire"));
        onView(withId(R.id.color)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("red"))).perform(click());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.level)).check(matches(withText("Your dragon is level 7")));

    }

    @Test
    public void TestNullMagicText() {

        onView(withId(R.id.magic_text_box)).perform(typeText(""));
        onView(withId(R.id.color)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("blue"))).perform(click());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.level)).check(matches(withText("Please type your magic selection exactly as it is shown")));

    }

}
