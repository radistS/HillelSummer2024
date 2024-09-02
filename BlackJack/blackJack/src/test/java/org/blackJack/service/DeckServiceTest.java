package org.blackJack.service;

import static org.junit.jupiter.api.Assertions.*;

import org.blackJack.exceptions.DeckException;

class DeckServiceTest {

    @org.junit.jupiter.api.Test
    void createDeck() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertEquals(52, deckService.getDeck().size());

        deckService.createDeck(2);
        assertEquals(104, deckService.getDeck().size());
    }

    @org.junit.jupiter.api.Test
    void createDeck_exception() {
        DeckService deckService = new DeckService();
        assertThrows(DeckException.class, () -> deckService.createDeck(0));
        assertThrows(DeckException.class, () -> deckService.createDeck(9));
    }

    @org.junit.jupiter.api.Test
    void getDeck() {
    }

    @org.junit.jupiter.api.Test
    void getCardCount() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertEquals(52, deckService.getCardCount());
    }

    @org.junit.jupiter.api.Test
    void getCard() {
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        assertEquals(52, deckService.getDeck().size());
        deckService.getCard();
        assertEquals(51, deckService.getDeck().size());
    }
}
