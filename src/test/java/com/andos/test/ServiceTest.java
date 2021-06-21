package com.andos.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServiceTest {

    @Test
    public void testPerformService() throws Exception {
        // Configure mock
        Collaborator collaboratorMock = mock(Collaborator.class);
        doReturn("output").when(collaboratorMock).transformString("input");

        // Perform the test
        Service service = new Service(collaboratorMock);
        String actual = service.performService("input");

        // Junit asserts
        String expected = "output";
        assertEquals(expected, actual);
    }
}
