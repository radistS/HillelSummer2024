package org.hillel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.hillel.user.User;
import org.hillel.user.UserCalculate;
import org.junit.jupiter.api.Test;

public class UserServiceTests {

    @Test
    void getFullname() {
        User user= new User();
        user.setName("name");
        assertEquals("name name", new UserCalculate().calculateFullName(user.getName()));
    }

    @Test
    void getFullname_mock() {
        UserCalculate uc = mock(UserCalculate.class);
        User user= new User();
        user.setName("name");

        when(uc.calculateFullName(eq("name"))).thenReturn("mock name");
        when(uc.calculateFullName(eq("oleksandr"))).thenReturn("mock oleksandr");
        assertEquals("mock name", uc.calculateFullName(user.getName()));

        user.setName("oleksandr");
        assertEquals("mock oleksandr", uc.calculateFullName(user.getName()));


        when(uc.calculateFullName(any())).thenReturn("mock name").thenReturn("mock ivan");

        assertEquals("mock name", uc.calculateFullName(user.getName()));
        assertEquals("mock ivan", uc.calculateFullName(user.getName()));

        verify(uc, times(4)).calculateFullName(any());
        verify(uc, times(1)).calculateFullName("name");
        verify(uc, times(3)).calculateFullName("oleksandr");

    }


    @Test
    void getFullname_mock_user() {
        UserCalculate uc = mock(UserCalculate.class);
        User user= mock(User.class);


        when(uc.calculateFullName(eq("name"))).thenReturn("mock name");
        when(uc.calculateFullName(eq("oleksandr"))).thenReturn("mock oleksandr");
        when(user.getName()).thenReturn("name");
        assertEquals("mock name", uc.calculateFullName(user.getName()));

        when(user.getName()).thenReturn("oleksandr");
        assertEquals("mock oleksandr", uc.calculateFullName(user.getName()));


        when(uc.calculateFullName(any())).thenReturn("mock name").thenReturn("mock ivan");

        assertEquals("mock name", uc.calculateFullName(user.getName()));
        assertEquals("mock ivan", uc.calculateFullName(user.getName()));

        verify(uc, times(4)).calculateFullName(any());
        verify(uc, times(1)).calculateFullName("name");
        verify(uc, times(3)).calculateFullName("oleksandr");

    }


    @Test
    void cacl(){
        User user = mock(User.class);
        when(user.getName())
            .thenReturn("1")
            .thenReturn("2")
            .thenReturn("3")
            .thenReturn("4");

        List<User> coll = List.of(user, user, user, user);

        assertEquals("1", coll.get(0).getName());
        assertEquals("2", coll.get(1).getName());
        assertEquals("3", coll.get(2).getName());
        assertEquals("4", coll.get(3).getName());

    }

}
