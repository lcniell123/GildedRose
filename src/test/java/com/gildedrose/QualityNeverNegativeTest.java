package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityNeverNegativeTest {

    @Test
    public void quality_above_0() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(0).build()};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
