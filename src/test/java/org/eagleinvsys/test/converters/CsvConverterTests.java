package org.eagleinvsys.test.converters;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eagleinvsys.test.converters.impl.ConvertibleCollectionImpl;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;

class CsvConverterTests {

    // TODO: implement JUnit 5 tests for CsvConverter

  @Captor
  private ArgumentCaptor<ConvertibleCollection> convertibleCollectionArgumentCaptor =
      ArgumentCaptor.forClass(ConvertibleCollection.class);

  @Captor
  private ArgumentCaptor<OutputStream> outputStreamArgumentCaptor = ArgumentCaptor.forClass(OutputStream.class);

  @Mock
  private CsvConverter csvConverter;

  private static ConvertibleCollection convertiblecollection;
  private static final List<Map<String, String>> list = new ArrayList<>();
  private static final OutputStream outputStream = new ByteArrayOutputStream();

  @BeforeAll
  static void setUp() {
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

    convertiblecollection = new ConvertibleCollectionImpl(list);

    try {
      outputStream.write(list.toString().getBytes(StandardCharsets.UTF_8));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

@Test
  void convert_convertMethodIsCalledOnce() {
    csvConverter = Mockito.mock(CsvConverter.class);

    csvConverter.convert(convertiblecollection, outputStream);
    Mockito.verify(csvConverter, Mockito.times(1))
        .convert(convertibleCollectionArgumentCaptor.capture(), outputStreamArgumentCaptor.capture());
}

  @Test
  void convert_ConvertableCollectionIsNull_nullPointerExceptionIsThrown() {

    assertThrows(NullPointerException.class, () -> csvConverter.convert(null, outputStream));
  }

  @Test
  void convert_outputStreamIsNull_nullPointerExceptionIsThrown() {

    assertThrows(NullPointerException.class, () -> csvConverter.convert(convertiblecollection, OutputStream.nullOutputStream()));
  }
}
