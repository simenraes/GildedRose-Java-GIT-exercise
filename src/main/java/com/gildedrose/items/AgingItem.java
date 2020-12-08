package com.gildedrose.items;

import com.gildedrose.core.Item;

public class AgingItem extends Item {

    public AgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int factor;
        if (this.sellIn >= 0) factor = 1;
        else factor = 2;
        this.quality = Math.min(this.quality + factor, 50);
    }
}
