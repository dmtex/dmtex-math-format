package com.github.dmtex.math.format.spi;

import com.github.dmtex.math.format.CompactFormat;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.Locale;

public class DefaultNumberFormatProvider extends NumberFormatProvider {

  @Override
  public NumberFormat getCurrencyInstance(Locale locale) {
    return new CompactFormat(4);
  }

  @Override
  public NumberFormat getIntegerInstance(Locale locale) {
    return new CompactFormat(4);
  }

  @Override
  public NumberFormat getNumberInstance(Locale locale) {
    return new CompactFormat(4);
  }

  @Override
  public NumberFormat getPercentInstance(Locale locale) {
    return new CompactFormat(4);
  }

  @Override
  public Locale[] getAvailableLocales() {
    return NumberFormat.getAvailableLocales();
  }
}
