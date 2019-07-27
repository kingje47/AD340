package com.jk.hw5;


import android.widget.CheckBox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class RoboDragonTest {

    Dragon dragon;
    CheckBox checkbox;

    @Test
    public void checkBox_fire_isChecked() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.checkbox_fire);

        checkbox = (CheckBox) checkbox.findViewById(R.id.checkbox_fire);

        Integer fireChecked = dragon.clicker(checkbox);
        Integer actualChecked = 4;
        assertEquals(actualChecked,fireChecked);

    }



}
