package org.example.sample.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream操作により非重複要素を取得する.
 */
public class UniqueCollection {

  /**
   * main.
   *
   * @param args 引数
   */
  public static void main(String[] args) {
    List<String> list = List.of("aaa", "bbb", "ccc", "ddd", "aaa", "ccc");

    var obj = new UniqueCollection();
    List<String> uniqueList = obj.getUniqueList(list);

    // bbb, ddd
    uniqueList.forEach(System.out::println);
  }

  /**
   * 重複していない要素を取得する.
   *
   * @param list 文字列リスト
   * @return ユニークリスト
   */
  public List<String> getUniqueList(final List<String> list) {
    return list.stream()
        .distinct()
        .filter(val -> Collections.frequency(list, val) == 1)
        .collect(Collectors.toList());
  }
}
