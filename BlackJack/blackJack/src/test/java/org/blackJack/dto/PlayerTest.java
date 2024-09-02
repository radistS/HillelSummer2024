package org.blackJack.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void testPlayer() {
        Player p = new Player("John");
        assertEquals("John", p.getName());
        assertEquals(0, p.getNumberOfGames());
        assertEquals(0, p.getNumberOfWins());
        assertEquals(0, p.getHand().size());

    }

}
