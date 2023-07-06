package com.gildedrose;

class GildedRose {
  GildedRoseItem[] items;

  public GildedRose(GildedRoseItem[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (GildedRoseItem item : items) {
      if (item.name.equals("Aged Brie")) {
        item.sellIn = item.sellIn - 1;
        if (item.quality < 50) {
          item.quality = item.quality + 1;
          if (item.sellIn < 0 ) {
            item.quality = item.quality + 1;
          }
        }  
      }

      else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.quality = item.quality - 1;
        if (item.quality < 50) {
          item.quality = item.quality + 1;
          if (item.sellIn < 0 ) {
            item.quality = item.quality + 1;
          }
        }
      }

      else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;

          if (item.sellIn < 11  && item.quality < 50) {
            item.quality = item.quality + 1;
          }

          if (item.sellIn < 6 && item.quality < 50) {
            item.quality = item.quality + 1;
          }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
          item.quality = item.quality - item.quality;
        }

      }

      else {
        if (item.quality > 0) {
          item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
          item.quality = item.quality - 1;
        }

        if (item.name.equals("Conjured")) {
          item.quality = item.quality - 2;
        }
      }
    }
  }
}