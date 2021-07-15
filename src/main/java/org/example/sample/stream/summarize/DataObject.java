package org.example.sample.stream.summarize;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Data Object.
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class DataObject {

  /**
   * key.
   */
  private final String key;

  /**
   * value.
   */
  private final String value;

  /**
   * description.
   */
  private String description = "";
}
