package org.eagleinvsys.test.converters.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.StandardConverter;

public class StandardCsvConverter implements StandardConverter {

  private final CsvConverter csvConverter;

  public StandardCsvConverter(CsvConverter csvConverter) {

    this.csvConverter = csvConverter;
  }

  /**
   * Converts given {@link List<Map>} to CSV and outputs result as a text to the provided {@link OutputStream}
   *
   * @param collectionToConvert collection to convert to CSV format. All maps must have the same set of keys
   * @param outputStream output stream to write CSV conversion result as text to
   */
  @Override
  public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) {
    // TODO: implement by using csvConverter

    ConvertibleCollection convertibleCollection = new ConvertibleCollectionImpl(collectionToConvert);
    csvConverter.convert(convertibleCollection, outputStream);
  }

  public static void main(String[] args) {
    List<Map<String, String>> list = new ArrayList<>();
    OutputStream outputStream = new ByteArrayOutputStream();
    CsvConverter csvConverter = new CsvConverter();
    StandardCsvConverter standardCsvConverter = new StandardCsvConverter(csvConverter);

    Map<String, String> map1 = new HashMap<>();
    map1.put("header1", "value1");
    map1.put("header2", "value2");
    map1.put("header3", "value3");
    map1.put("header4", "value4");
    Map<String, String> map2 = new HashMap<>();
    map2.put("header1", "value5");
    map2.put("header2", "value6");
    map2.put("header3", "value7");
    map2.put("header4", "value8");
    list.add(map1);
    list.add(map2);

    try {
      outputStream.write(list.toString()
          .getBytes(StandardCharsets.UTF_8));
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    standardCsvConverter.convert(list, outputStream);
    System.out.println(list);
    System.out.println(outputStream);
  }
}
