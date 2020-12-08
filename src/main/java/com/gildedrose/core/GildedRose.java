package com.gildedrose.core;

import java.util.Arrays;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void calculateNextDay() {
        for (Item item:items) {
            item.updateSellInValue();
            item.updateQuality();
        }
    }
}