package com.gildedrose;

public class AdjustQuality {

    public int abc = 3;

    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    public void adjustItemQualityIfInRange(Item item, int adjNum) {
        int newItemQuality = item.quality + adjNum;
        if (newItemQuality <= 50 && newItemQuality >= 0) {
            item.quality = newItemQuality;
        }
    }

}
