package com.github.dmtex.math.unicode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SubscriptHelperTest {

  private final SubscriptHelper helper = new SubscriptHelper();

  @Test
  void testTo() {
    assertAll(
        () -> assertEquals("\u2081", helper.to("1")),
        () -> assertEquals("\u208B\u2082", helper.to("-2"))
    );
  }

  @Test
  void testFrom() {
    assertAll(
        () -> assertEquals("1", helper.from("\u2081")),
        () -> assertEquals("-2", helper.from("\u208B\u2082")),
        () -> assertThrows(NumberFormatException.class, () -> helper.from("a"))
    );
  }
}
