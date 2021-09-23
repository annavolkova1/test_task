package org.eagleinvsys.test.converters;

import java.io.OutputStream;

public interface Converter {

  /**
   * Converts given {@link ConvertibleCollection} and outputs result as a text to the provided {@link OutputStream}
   *
   * @param collectionToConvert collection to convert
   * @param outputStream output stream to write results to
   */
  void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream);
}
