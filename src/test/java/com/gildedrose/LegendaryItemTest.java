package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.LegendaryItem;
import org.junit.jupiter.api.Test;

public class LegendaryItemTest {

    private Item[] items = new Item[] {new LegendaryItem("Sulfuras, Hand of Ragnaros", 10, 50)};
    private GildedRose app = new GildedRose(items);

    @Test
    void qualityNeverChanges() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 10);
        assert(app.items[0].quality == 50);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 10);
        assert(app.items[0].quality == 50);
    }

    @Test
    void notEvenExpired() {
        app.items[0].sellIn = 1;
        app.items[0].quality = 50;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 1);
        assert(app.items[0].quality == 50);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 1);
        assert(app.items[0].quality == 50);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 1);
        assert(app.items[0].quality == 50);
    }
}