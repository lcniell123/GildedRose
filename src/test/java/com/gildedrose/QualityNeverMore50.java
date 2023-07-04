package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityNeverMore50Test {

   @Test
    public void quality_below_50() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(20)
                .ofQuality(50).build()};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

}
