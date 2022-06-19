package com.github.dmtex.math.format;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * To run test use option:
 * -Djava.locale.providers=SPI
 */
class CompactFormatTest {

  private final NumberFormat format = new CompactFormat(4);

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormat() {
    assertAll(
        () -> assertEquals("0", format.format(0)),
        () -> assertEquals("1", format.format(1)),
        () -> assertEquals("1", new CompactFormat(0).format(1)),
        () -> assertEquals("1.235E-5", format.format(0.0000123456789)),
        () -> assertEquals("1E6", new CompactFormat(2).format(1000000)),
        () -> assertEquals("1E-6", new CompactFormat(2).format(0.000001))
    );
  }

  @Test
  void testParse() {
    assertAll(
        () -> assertEquals(BigDecimal.ONE, format.parse("1E0")),
        () -> assertEquals(BigDecimal.valueOf(1e7), format.parse("1.0E7"))
    );
  }
}
