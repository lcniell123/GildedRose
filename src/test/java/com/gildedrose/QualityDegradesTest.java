package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityDegradesTest {

    @Test
    public void degrades_after_sell_date() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").pastExpirationDate().ofQuality(10).build()};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }


}
