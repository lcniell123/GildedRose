package com.gildedrose;

public class GildedRoseMake {
    private int quality;
    private int sellIn;
    private String name;

    public GildedRoseMake() {
        this.name = "";
        this.quality = 0;
        this.sellIn = 0;
    }

    public GildedRoseMake called(String name) {
        this.name = name;
        return this;
    }

    public GildedRoseMake ofQuality(int quality) {
        this.quality = quality;
        return this;
    }

    public GildedRoseMake toBeSoldIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    public GildedRoseMake pastExpirationDate() {
        this.sellIn = 0;
        return this;
    }

    public GildedRoseItem build() {
        return new GildedRoseItem(name, sellIn, quality);
    }
}