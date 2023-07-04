package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SellInValueTest {

    @Test
    public void sellIn_value() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(0).build()};
        GildedRose app = new GildedRose(items);

        assertEquals(10, app.items[0].sellIn);
    }

}
