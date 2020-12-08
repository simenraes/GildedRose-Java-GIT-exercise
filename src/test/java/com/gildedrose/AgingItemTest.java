package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.AgingItem;
import org.junit.jupiter.api.Test;

public class AgingItemTest {

    private Item[] items = new Item[] {new AgingItem("Aged Brie", 10, 20)};
    private GildedRose app = new GildedRose(items);

    @Test
    void increaseQualityNormal() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 21);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 8);
        assert(app.items[0].quality == 22);
    }

    @Test
    void increaseQualityExpired() {
        app.items[0].sellIn = 1;
        app.items[0].quality = 20;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 21);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -1);
        assert(app.items[0].quality == 23);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -2);
        assert(app.items[0].quality == 25);
    }

    @Test
    void noQualityAbove50() {
        app.items[0].sellIn = 10;
        app.items[0].quality = 49;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 50);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 8);
        assert(app.items[0].quality == 50);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 7);
        assert(app.items[0].quality == 50);
    }
}
