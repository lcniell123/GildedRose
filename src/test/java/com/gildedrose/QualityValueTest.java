package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityValueTest {

      @Test
    public void quality_value() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(0).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);


        assertEquals(10, app.items[0].quality);
    }

}
