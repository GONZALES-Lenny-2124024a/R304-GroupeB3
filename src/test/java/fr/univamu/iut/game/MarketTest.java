package fr.univamu.iut.game;

import fr.univamu.iut.game.market.Market;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Market enumerator
 */
public class MarketTest {
    @Test
    public void shouldGetArcherPrice() {
        assertEquals(Market.ARCHER.getPrice(), 200);
    }

    @Test
    public void shouldGetHealerPrice() {
        assertEquals(Market.HEALER.getPrice(), 100);
    }

    @Test
    public void shouldGetMagePrice() {
        assertEquals(Market.MAGE.getPrice(), 75);
    }
}
