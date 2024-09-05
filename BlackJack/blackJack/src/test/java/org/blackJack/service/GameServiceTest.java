package org.blackJack.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.blackJack.dto.Card;
import org.blackJack.dto.GameResult;
import org.blackJack.dto.Rank;
import org.blackJack.dto.Suit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirect System.out to outContent
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
    }

    @RepeatedTest(10)
    void getComputerHand() {
        GameService gs = new GameService();
        assertTrue(gs.getComputerHand() > 17 || gs.getComputerHand() < 25);
    }

    @Test
    void printHand() {
        GameService gs = new GameService();
        List<Card> cards = List.of(new Card(Suit.Spades, Rank.Ace), new Card(Suit.Spades, Rank.Jack));
        gs.printHand(cards);
        assertEquals("A♠ J♠ ", outContent.toString());
    }

    @Test
    public void testCalculateHandScore_noBlackJack() {
        GameService gs = new GameService();
        // Test hand with no blackjack
        Card card1 = new Card(Suit.Spades, Rank.Five);
        Card card2 = new Card(Suit.Spades, Rank.Eight);
        List<Card> hand = Arrays.asList(card1, card2);

        int score = gs.calculateHandScore(hand);
        assertEquals( 13, score);
    }

    @Test
    public void testCalculateHandScore_isBlackJack() {
        GameService gs = new GameService();
        // Test hand with no blackjack
        Card card1 = new Card(Suit.Spades, Rank.Ace);
        Card card2 = new Card(Suit.Clubs, Rank.Ace);
        List<Card> hand = Arrays.asList(card1, card2);

        int score = gs.calculateHandScore(hand);
        assertEquals( 21, score);
    }

    @ParameterizedTest
    @MethodSource("points")
    void getGameResult(int computer, int player, GameResult expected) {
        GameService gs = new GameService();
        assertEquals(expected, gs.getGameResult(computer, player));
    }

    private static Stream<Arguments> points() {
        return Stream.of(
            Arguments.of(21, 21, GameResult.DRAW),
            Arguments.of(22, 22, GameResult.LOSE),
            Arguments.of(18, 22, GameResult.COMPUTER),
            Arguments.of(22, 18, GameResult.PLAYER),
            Arguments.of(18, 17, GameResult.COMPUTER),
            Arguments.of(14, 20, GameResult.PLAYER),
            Arguments.of(18, 18, GameResult.DRAW)
        );
    }
}
