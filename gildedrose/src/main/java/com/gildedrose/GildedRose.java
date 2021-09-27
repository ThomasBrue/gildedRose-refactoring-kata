package com.gildedrose;

public class GildedRose {

    private Item[] items;
    AdjustQuality adjustQuality = new AdjustQuality();

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            adjustQuality.updateItemQuality(item);
        }
    }

    public Item[] getItems() {
        return items;
    }
}
