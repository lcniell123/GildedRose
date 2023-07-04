package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityLowerPerDay {

    @Test
    public void lower_quality_per_day() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

}
