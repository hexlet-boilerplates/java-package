package io.hexlet.boilerplate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.TestUtils.fromSystemOutPrintln;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HelloWorldTest {

    @Test
    @DisplayName("\"main\" method works correctly")
    void testMain() {
        assertThat(fromSystemOutPrintln(HelloWorld::main))
                .isEqualTo("Hello, World!");
    }
}
