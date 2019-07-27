package com.jk.hw5;

import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DragonTest {

    Dragon dragon;
    CheckBox checkbox;

    @Mock
    Context mockContext;

    @Mock
    Resources mockResources;

    @Mock
    CheckBox mockCheckbox;


    @Before
    public void setUp() {
        this.dragon = new Dragon(null, 0);

        //mockCheckbox = (CheckBox) mockCheckbox.findViewById(R.id.checkbox_fire);

        MockitoAnnotations.initMocks(this);

        when(mockContext.getString(R.string.default_color)).thenReturn(null);
        when(mockContext.getString(R.string.default_magic)).thenReturn("0");
    }

    @Test
    public void defaultDragon_returnsCorrectValues() {
        Dragon defaultDragon = new Dragon(mockContext);

        String redDragon = defaultDragon.getColor();
        assertThat(redDragon).isEqualTo(null);
    }

    @Test
    public void dragon_returnsCorrectDragonColorLevel() {
        Integer dragonColorRed = dragon.colorLevel("red");
        assertThat(dragonColorRed).isEqualTo(3);

        Integer dragonColorBlue = dragon.colorLevel("blue");
        assertThat(dragonColorBlue).isEqualTo(2);

        Integer dragonColorGreen = dragon.colorLevel("green");
        assertThat(dragonColorGreen).isEqualTo(5);

    }

    @Test
    public void dragon_returnsCorrectDragonMagicLevel() {



        Integer fireChecked = dragon.clicker(mockCheckbox);
        assertThat(fireChecked).isEqualTo(4);

    }

    @After
    public void tearDown() {

    }


}
