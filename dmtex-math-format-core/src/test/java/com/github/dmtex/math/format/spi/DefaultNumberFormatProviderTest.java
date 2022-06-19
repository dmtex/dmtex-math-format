package com.github.dmtex.math.format.spi;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.dmtex.math.format.CompactFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DefaultNumberFormatProviderTest {

  private final NumberFormat format = new DefaultNumberFormatProvider().getNumberInstance(Locale.US);

  @Test
  void test() {
    assertAll(
        () -> assertEquals("0", format.format(0)),
        () -> assertEquals("1", format.format(1)),
        () -> assertEquals("1", format.format(1)),
        () -> assertEquals("1.235E-5", format.format(0.0000123456789)),
        () -> assertEquals("1E10", format.format(10000000000L)),
        () -> assertEquals("1E-6", format.format(0.000001))
    );
  }
}
