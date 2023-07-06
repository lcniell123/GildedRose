package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


// All items have a SellIn value which denotes the number of days we have to sell the item 
@Test
public void sellIn_value() throws Exception {
    GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(0).build()};
    GildedRose app = new GildedRose(items);
    assertEquals(10, app.items[0].sellIn);
}

// All items have a Quality value which enotes how valuable the item is 
@Test
public void quality_value() throws Exception {
    GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(0).ofQuality(10).build()};
    GildedRose app = new GildedRose(items);
    assertEquals(10, app.items[0].quality);
}

// At the end of each day our system lowers both values for every item 
@Test
public void lower_quality_per_day() throws Exception {
    GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(10).build()};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(9, app.items[0].quality);
}
// Once the sell by date has passed, Quality degrades twice as fast 
@Test
public void degrades_after_sell_date() throws Exception {
    GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").pastExpirationDate().ofQuality(10).build()};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(8, app.items[0].quality);
}
// The Quality of an item is never negative 
@Test
public void quality_above_0() throws Exception {
    GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Gilded Rose Item").toBeSoldIn(10).ofQuality(0).build()};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
}

// The Quality of an item is never more than 50 
@Test
    public void quality_below_50() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(20)
                .ofQuality(50).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

// "Aged Brie" actually increases in Quality the older it gets 
@Test
    public void aged_brie_test() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Aged Brie").ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

// "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
@Test
    public void sulfuras_test() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Sulfuras, Hand of Ragnaros").toBeSoldIn(10).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

@Test
    public void sulfuras_test_2() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Sulfuras, Hand of Ragnaros").toBeSoldIn(-1).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

// "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches; 
// Quality increases by 2 when there are 10 days or less and 
@Test
    public void backstage_test_2() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(10).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

// by 3 when there are 5 days or less 
@Test
    public void backstage_test_3() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(5).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

// but Quality drops to 0 after the concert
@Test
    public void backstage_test_4() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Backstage passes to a TAFKAL80ETC concert").toBeSoldIn(0).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

//Conjured items degrade twice as fast as ordinary items. 
@Test
    public void conjured() throws Exception {
        GildedRoseItem[] items = new GildedRoseItem[]{new GildedRoseMake().called("Conjured").toBeSoldIn(5).ofQuality(10).build()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }
}
