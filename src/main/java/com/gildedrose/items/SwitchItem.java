package com.gildedrose.items;

import com.gildedrose.core.Item;

public class SwitchItem extends Item {
    public SwitchItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int factor;
        while (sellIn >= 0 && this.quality <= 50) {
            factor = 1;
            this.quality = Math.max(this.quality + factor, 0);
        }

        if (sellIn < 0 && this.quality >= 0) {
            factor = 1;
            this.quality = Math.max(this.quality - factor, 0);


        }
        else {
            factor= 2;
        }
    }
}
