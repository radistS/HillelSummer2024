package org.blackJack.dto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.blackJack.service.GameService;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void testComputer() {

        GameService gs = mock(GameService.class);
        when(gs.getComputerHand()).thenReturn(17).thenReturn(20);

        Computer computer = new Computer(gs);

        assertEquals(17, computer.getHandCount());
        assertEquals(20, computer.getHandCount());

    }
  
}
