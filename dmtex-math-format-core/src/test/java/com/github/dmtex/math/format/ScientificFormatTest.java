package com.github.dmtex.math.format;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScientificFormatTest {

  private final NumberFormat format = new ScientificFormat(4);

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormat() {
    assertAll(
        () -> assertEquals("1E0", format.format(1)),
        () -> assertEquals("1.2346E-5", format.format(0.0000123456789)),
        () -> assertEquals("1E0", new ScientificFormat(0).format(1))
    );
  }

  @Test
  void testParse() {
    assertAll(
        () -> assertEquals(BigDecimal.ONE, format.parse("1E0")),
        () -> assertThrows(NumberFormatException.class, () -> format.parse("A"))
    );
  }
}
