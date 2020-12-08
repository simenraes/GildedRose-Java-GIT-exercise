package com.gildedrose.items;

import com.gildedrose.core.Item;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int factor;
        if (this.sellIn >= 0) factor = 2;
        else factor = 4;
        this.quality = Math.max(this.quality - factor, 0);
    }
}
