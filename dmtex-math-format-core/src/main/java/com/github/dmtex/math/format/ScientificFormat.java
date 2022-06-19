package com.github.dmtex.math.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * {@code ScientificFormat} class is responsible to scientific format.
 *
 * @author Denis Murashev
 *
 * @since Math Format 1.0
 */
public class ScientificFormat extends NumberFormat {

  private static final long serialVersionUID = 1324549182818069728L;

  private static final String E_ZERO = "E0";

  private final String format;

  /**
   * Initializes with given value.
   *
   * @param digits digits
   */
  public ScientificFormat(int digits) {
    if (digits <= 0) {
      format = "0E0";
    } else {
      format = "0." + "#".repeat(digits) + E_ZERO;
    }
  }

  @Override
  public final StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
    String value = new DecimalFormat(format).format(number);
    int index = value.indexOf('E');
    return toAppendTo.append(value, 0, index)
        .append(getTimes())
        .append(toSup(value.substring(index + 1)));
  }

  @Override
  public final StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
    return format((double) number, toAppendTo, pos);
  }

  /**
   * The implementation should provide times symbol.
   *
   * @return times symbol
   */
  protected String getTimes() {
    return "E";
  }

  /**
   * The implementation should provide given value representation as superscript.
   *
   * @param value value
   * @return representation
   */
  protected String toSup(String value) {
    return value;
  }

  @Override
  public Number parse(String source, ParsePosition parsePosition) {
    parsePosition.setIndex(parsePosition.getIndex() + source.length());
    return new BigDecimal(source);
  }
}
