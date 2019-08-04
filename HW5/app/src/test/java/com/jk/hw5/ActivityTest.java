package com.jk.hw5;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ActivityTest {

    @Test
    public void testCheckForValidStringInput() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

//        test for valid responses, typos, and capitalization. -> capitalization should not matter
        assertTrue(activity.stringChecker("fire"));
        assertFalse(activity.stringChecker("firee"));
        assertTrue(activity.stringChecker("water"));
        assertTrue(activity.stringChecker("WATER"));
        assertTrue(activity.stringChecker("lightning"));
        assertFalse(activity.stringChecker("lihgtning"));
    }

}
