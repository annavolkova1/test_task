package org.eagleinvsys.test.converters;

public interface ConvertibleMessage {

  /**
   * Gets value of the provided element from this message
   *
   * @param elementId id of the element to get value of
   * @return value of the provided element
   */
  String getElement(String elementId);
}
