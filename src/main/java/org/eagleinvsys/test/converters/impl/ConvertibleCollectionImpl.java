package org.eagleinvsys.test.converters.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

public class ConvertibleCollectionImpl implements ConvertibleCollection {

  private List<Map<String, String>> collectionToConvert;
  private List<String> headers;
  private List<ConvertibleMessage> records;

  public ConvertibleCollectionImpl(List<Map<String, String>> collectionToConvert) {

    this.collectionToConvert = collectionToConvert;

    headers = collectionToConvert
        .stream()
        .flatMap(map -> map.keySet().stream())
        .distinct()
        .collect(Collectors.toList());

    records = collectionToConvert
        .stream()
        .map(ConvertibleMessageImpl::new)
        .collect(Collectors.toList());
  }

  @Override
  public Collection<String> getHeaders() {

    return headers;
  }

  @Override
  public Iterable<ConvertibleMessage> getRecords() {

    return records;
  }
}
