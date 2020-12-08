package com.gildedrose;

import com.gildedrose.core.GildedRose;
import com.gildedrose.core.Item;
import com.gildedrose.items.TicketItem;
import org.junit.jupiter.api.Test;

public class TicketItemTest {

    private Item[] items = new Item[] {new TicketItem("Backstage passes to a TAFKAL80ETC concert", 20, 20)};
    private GildedRose app = new GildedRose(items);

    @Test
    void increaseQuality() {
        app.calculateNextDay();
        assert(app.items[0].sellIn == 19);
        assert(app.items[0].quality == 21);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 18);
        assert(app.items[0].quality == 22);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 17);
        assert(app.items[0].quality == 23);
    }

    @Test
    void doubleIncrease() {
        app.items[0].sellIn = 10;
        app.items[0].quality = 20;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 9);
        assert(app.items[0].quality == 22);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 8);
        assert(app.items[0].quality == 24);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 7);
        assert(app.items[0].quality == 26);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 6);
        assert(app.items[0].quality == 28);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 5);
        assert(app.items[0].quality == 30);
    }

    @Test
    void tripleIncrease() {
        app.items[0].sellIn = 5;
        app.items[0].quality = 30;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 4);
        assert(app.items[0].quality == 33);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 3);
        assert(app.items[0].quality == 36);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 2);
        assert(app.items[0].quality == 39);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 1);
        assert(app.items[0].quality == 42);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 45);
    }

    //TODO: Add a test to make sure quality does not go above 50

    @Test
    void loseQualityAfterExpiration() {
        app.items[0].sellIn = 2;
        app.items[0].quality = 10;
        app.calculateNextDay();
        assert(app.items[0].sellIn == 1);
        assert(app.items[0].quality == 13);
        app.calculateNextDay();
        assert(app.items[0].sellIn == 0);
        assert(app.items[0].quality == 16);
        app.calculateNextDay();
        assert(app.items[0].sellIn == -1);
        assert(app.items[0].quality == 0);
    }

}
