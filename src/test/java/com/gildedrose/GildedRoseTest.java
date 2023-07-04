package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.Arrays;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assert.assertEquals;

class GildedRoseTest {

    // @Test
    // void foo() {
    //     Item[] items = new Item[] { new Item("fixme", 0, 0) };
    //     GildedRose app = new GildedRose(items);
    //     app.updateQuality();
    //     assertEquals("fixme", app.items[0].name);
    // }
    @Test
    public void should_lower_quality_and_sellIn_values_of_every_item_at_the_end_of_each_day() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

}
