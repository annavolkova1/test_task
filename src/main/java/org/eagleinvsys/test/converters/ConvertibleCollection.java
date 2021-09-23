package org.eagleinvsys.test.converters;

import java.util.Collection;

public interface ConvertibleCollection {

  /**
   * Gets headers of this convertible collection. All records of the collection are considered to have the
   * same headers
   *
   * @return headers of the convertible collection
   */
  Collection<String> getHeaders();

  /**
   * Gets data records of this convertible collection
   *
   * @return data records of the convertible collection
   */
  Iterable<ConvertibleMessage> getRecords();
}
