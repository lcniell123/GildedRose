package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        GildedRoseItem[] items = new GildedRoseItem[] {
                new GildedRoseItem("+5 Dexterity Vest", 10, 20), //
                new GildedRoseItem("Aged Brie", 2, 0), //
                new GildedRoseItem("Elixir of the Mongoose", 5, 7), //
                new GildedRoseItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                new GildedRoseItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new GildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new GildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new GildedRoseItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new GildedRoseItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (GildedRoseItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
