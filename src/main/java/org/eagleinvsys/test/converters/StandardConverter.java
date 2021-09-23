package org.eagleinvsys.test.converters;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface StandardConverter {

  /**
   * Converts given {@link List<Map>} and outputs result as a text to the provided {@link OutputStream}
   *
   * @param collectionToConvert collection to convert. All maps must have the same set of keys
   * @param outputStream output stream to write results to
   */
  void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream);
}
