package org.example.sample.stream.summarize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Objectの任意の項目でリストを集約する.
 */
public class KeySummary {

  /**
   * main.
   *
   * @param args 引数
   */
  public static void main(String[] args) {
    List<DataObject> list = List.of(
        DataObject.of("1", "aaaa"),
        DataObject.of("2", "bbbb"),
        DataObject.of("1", "cccc"),
        DataObject.of("3", "dddd"),
        DataObject.of("3", "eeee"),
        DataObject.of("4", "ffff")
    );

    var obj = new KeySummary();
    Map<String, List<DataObject>> summaryList = obj.summarize(list);
    summaryList.forEach(obj::show);
  }

  /**
   * DataObjectのkeyで集約する.
   *
   * @param list DataObjectリスト
   * @return key, DataObjectリストのMAP
   */
  public Map<String, List<DataObject>> summarize(final List<DataObject> list) {
    return list.stream()
        .collect(Collectors.groupingBy(data -> data.getKey()));
  }

  /**
   * 表示する.
   *
   * @param key  key
   * @param list DataObjectリスト
   */
  public void show(final String key, final List<DataObject> list) {
    System.out.println(String.format("key=%1$s", key));
    list.stream().forEach(System.out::println);
    System.out.println("---");
  }
}
