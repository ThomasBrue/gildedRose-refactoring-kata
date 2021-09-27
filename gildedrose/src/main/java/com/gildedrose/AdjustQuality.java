package com.gildedrose;

public class AdjustQuality implements Products {

    public void updateItemQuality(Item item) {
        if (!item.name.equals(BRIE) && !item.name.equals(BACKSTAGE)) {
            notIncreaseSulfuras(item);
        }
        if (item.name.equals(BRIE) || item.name.equals(BACKSTAGE)) {
            adjustItemQualityInRange(item, 1);
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
            adjustItemQualityInRange(item, -1);
        }
    }

    private void adjustBackstage(Item item) {
        if (item.sellIn < 11 && item.name.equals(BACKSTAGE)) {
            adjustItemQualityInRange(item, 1);
        }
        if (item.sellIn < 6 && item.name.equals(BACKSTAGE)) {
            adjustItemQualityInRange(item, 1);
        }
    }

    private void itemOverdue(Item item) {
        if (!item.name.equals(BRIE) && !item.name.equals(BACKSTAGE) && !item.name.equals(SULFURAS)) {
            adjustItemQualityInRange(item, -1);
        }
        if (item.name.equals(BRIE)) {
            adjustItemQualityInRange(item, 1);
        }
        if (item.name.equals(BACKSTAGE)) {
            item.quality = item.quality - item.quality;
        }
    }

    private void adjustItemQualityInRange(Item item, int adjNum) {
        int newItemQuality = item.quality + adjNum;
        if (newItemQuality <= 50 && newItemQuality >= 0) {
            item.quality = newItemQuality;
        }
    }

}