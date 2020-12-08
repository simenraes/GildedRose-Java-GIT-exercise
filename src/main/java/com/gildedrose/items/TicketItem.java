package com.gildedrose.items;

import com.gildedrose.core.Item;

public class TicketItem extends Item {

    public TicketItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // Quality should be zero after sellIn date
        if (sellIn < 0) quality = 0;
        else {
            int quality_factor;
            // Quality factor is 3 in the last 5 days
            if (sellIn < 5) quality_factor = 3;
                // Quality factor is 2 between 5 and 10 days
            else if (sellIn < 10) quality_factor = 2;
                // Quality factor is 1 when more than 10 days
            else quality_factor = 1;
            quality = Math.min(quality + quality_factor, 50);
        }
    }
}
