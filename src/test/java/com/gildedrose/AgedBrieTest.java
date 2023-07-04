package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

    @Test
    void foo() {
        GildedRoseItem[] items = new GildedRoseItem[] { new GildedRoseItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
