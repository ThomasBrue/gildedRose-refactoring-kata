package com.gildedrose;

public class GildedRose {

    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private Item[] items;

    AdjustQuality adjustQuality = new AdjustQuality();

    public GildedRose(Item... items) {
        // tb.abc = 5;
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals(BRIE) && !item.name.equals(BACKSTAGE)) {
            notIncreaseSulfuras(item);
        } else {
            adjustItemQualityIfInRange(item, 1);
            adjustBackstage(item);
        }
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < 0) {
            itemOverdue(item);
        }
    }

    private void notIncreaseSulfuras(Item item) {
        if (!item.name.equals(SULFURAS)) {
            adjustItemQualityIfInRange(item, -1);
        }
    }

    private void adjustBackstage(Item item) {
        if (item.sellIn < 11 && item.name.equals(BACKSTAGE)) {
            adjustItemQualityIfInRange(item, 1);
        }
        if (item.sellIn < 6 && item.name.equals(BACKSTAGE)) {
            adjustItemQualityIfInRange(item, 1);
        }
    }

    private void itemOverdue(Item item) {
        if (!item.name.equals(BRIE) && !item.name.equals(BACKSTAGE) && !item.name.equals(SULFURAS)) {
            adjustItemQualityIfInRange(item, -1);
        }
        if (item.name.equals(BRIE)) {
            adjustItemQualityIfInRange(item, 1);
        }
        if (item.name.equals(BACKSTAGE)) {
            item.quality = item.quality - item.quality;
        }
    }

    private void adjustItemQualityIfInRange(Item item, int adjNum) {
        int newItemQuality = item.quality + adjNum;
        if (newItemQuality <= 50 && newItemQuality >= 0) {
            item.quality = newItemQuality;
        }
    }

    // --------------------------------------------------------------------------------------------

    public Item[] getItems() {
        return items;
    }
}
