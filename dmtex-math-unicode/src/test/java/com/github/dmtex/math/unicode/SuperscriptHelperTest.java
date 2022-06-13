package com.github.dmtex.math.unicode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuperscriptHelperTest {

  private final SuperscriptHelper helper = new SuperscriptHelper();

  @Test
  void testTo() {
    assertAll(
        () -> assertEquals("\u00B9", helper.to("1")),
        () -> assertEquals("\u207B\u00B2", helper.to("-2"))
    );
  }

  @Test
  void testFrom() {
    assertAll(
        () -> assertEquals("1", helper.from("\u00B9")),
        () -> assertEquals("-2", helper.from("\u207B\u00B2")),
        () -> assertThrows(NumberFormatException.class, () -> helper.from("a"))
    );
  }
}
