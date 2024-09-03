package hello;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void testSumarDosNumerosEnterosPositivos() {
        // Arrange
        HelloWorld s = new HelloWorld();

        // Act
        int result = s.sumar(10,35);

        // Assert
        assertEquals(45, result);
    }
}
