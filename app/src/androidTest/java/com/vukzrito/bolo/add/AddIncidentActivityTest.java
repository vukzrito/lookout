package com.vukzrito.bolo.add;

import android.support.test.rule.ActivityTestRule;

import com.vukzrito.bolo.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AddIncidentActivityTest {
    @Rule
    public ActivityTestRule<AddIncidentActivity> activityTestRule = new ActivityTestRule<>(AddIncidentActivity.class);

    @Test
    public void testThatSubmitButtonSubmitsForm() {
        onView(withId(R.id.registration_number)).perform(typeText("BK35FXGP"));
        onView(withId(R.id.vin)).perform(typeText("BTF3PL86F3G5VC4D2"));
        onView(withId(R.id.make)).perform(typeText("TOYOTA"));
        onView(withId(R.id.model)).perform(typeText("Corolla"));
        onView(withId(R.id.color)).perform(typeText("Metallic Blue"), closeSoftKeyboard());

        onView(withId(R.id.btn_submit)).perform(click());
    }


}
