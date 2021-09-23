package org.eagleinvsys.test.converters.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

public class CsvConverter implements Converter {

  /**
   * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
   *
   * @param collectionToConvert collection to convert to CSV format
   * @param outputStream output stream to write CSV conversion result as text to
   */
  @Override
  public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
    // TODO: implement

    List<String> headers = new ArrayList<>(collectionToConvert.getHeaders());
    Iterable<ConvertibleMessage> records = collectionToConvert.getRecords();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < headers.size(); i++) {
      sb.append(headers.get(i));
      sb.append(i == headers.size() - 1 ? "\n" : ",");
    }

    records.forEach(map -> {
      for (int i = 0; i < headers.size(); i++) {
        sb.append(map.getElement(headers.get(i)));
        sb.append(i == headers.size() - 1 ? "\n" : ",");
      }
    });

    try {
      outputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
