package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.ConjuredItem;
import org.junit.jupiter.api.Test;

public class ConjuredItemTest {

    private Item[] items = new Item[] {new ConjuredItem("Conjured Mana Cake", 10, 20)};
    private GildedRose app = new GildedRose(items);

    @Test
    void decreaseQualityNormal() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 18);
    }

    @Test
    void decreaseQualityExpired() {
        app.items[0].sellIn = 1;
        app.items[0].quality = 20;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 18);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -1);
        assert(app.items[0].quality == 14);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 10);
    }

    @Test
    void noQualityBelowZero() {
        app.items[0].sellIn = 1;
        app.items[0].quality = 1;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 0);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -1);
        assert(app.items[0].quality == 0);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 0);
    }
}