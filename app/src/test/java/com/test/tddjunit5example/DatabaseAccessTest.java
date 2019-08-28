package com.test.tddjunit5example;

import com.test.tddjunit5example.airconditioning.Credentials;
import com.test.tddjunit5example.airconditioning.Database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MokitoExtension.class)
public class DatabaseAccessTest
{
    @Mock
    private Database database;

    private Credentials credentials = new Credentials("username","password");

    @Test
    void testUserSucessfulLogin()
    {
        when(database.login(credentials)).thenReturn(true);
        Credentials credentials1 = new Credentials("username","password");
        assertTrue(database.login(credentials1));
    }

    @Test
    void testUserFailedLogin()
    {
        when(database.login(credentials)).thenReturn(true);
        Credentials otherCredentials = new Credentials("username","password");
        otherCredentials.setUsername("user");
        otherCredentials.setPassword("passw");
        assertNotEquals(credentials.getUsername(),otherCredentials.getUsername());
        assertNotEquals(credentials.getUsername(),otherCredentials.getUsername());
        assertNotEquals(credentials.hashCode(),otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }
}
