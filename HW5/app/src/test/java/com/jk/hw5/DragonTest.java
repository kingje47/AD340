package com.jk.hw5;

import android.content.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

//Unit testing based on Canvas video

public class DragonTest {

    Dragon dragon;

    @Mock
    Context mockContext;

    @Before
    public void setUp() {
        this.dragon = new Dragon(null, null);

        MockitoAnnotations.initMocks(this);

        when(mockContext.getString(R.string.default_color)).thenReturn(null);
        when(mockContext.getString(R.string.default_magic)).thenReturn(null);
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
        Integer dragonMagicFire = dragon.magicLevel("fire");
        assertThat(dragonMagicFire).isEqualTo(4);

        Integer dragonMagicLightning = dragon.magicLevel("lightning");
        assertThat(dragonMagicLightning).isEqualTo(1);

        Integer dragonMagicWater = dragon.magicLevel("water");
        assertThat(dragonMagicWater).isEqualTo(3);

    }

    @After
    public void tearDown() {

    }


}
