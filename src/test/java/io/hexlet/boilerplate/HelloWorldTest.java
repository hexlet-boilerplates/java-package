package io.hexlet.boilerplate;

import java.io.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("\"main\" method works correctly")
    void testMain() {
        HelloWorld.main();
        assertThat(output.toString().trim())
                .isEqualTo("Hello, World!");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
