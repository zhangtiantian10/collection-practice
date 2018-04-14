package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
      int min = Math.min(left, right);
      int max = Math.max(left, right);
      Stream<Integer> boxed = IntStream.rangeClosed(min, max)
        .boxed();
      if (left < right) {
        return boxed.collect(Collectors.toList());
      }
      return boxed.sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
      int min = Math.min(left, right);
      int max = Math.max(left, right);
      Stream<Integer> boxed = IntStream.rangeClosed(min, max)
        .boxed()
        .filter(item -> item % 2 == 0);
      if (left < right) {
        return boxed.collect(Collectors.toList());
      }
      return boxed.sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
      return Arrays.stream(array)
        .boxed()
        .filter(item -> item % 2 == 0)
        .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array)
          .boxed()
          .reduce((result, item) -> item)
          .get();

    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
      List<Integer> list = Arrays.stream(secondArray)
        .boxed()
        .collect(Collectors.toList());
      return Arrays.stream(firstArray)
        .boxed()
        .filter(item -> list.contains(item))
        .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
      List<Integer> secondList = Arrays.stream(secondArray)
        .collect(Collectors.toList());
      List<Integer> firstList = Arrays.stream(firstArray)
        .collect(Collectors.toList());
      Stream<Integer> uncommonFirstStream = secondList.stream()
        .filter(item -> !firstList.contains(item));
      Stream<Integer> uncommonSecondStream = firstList.stream();
      return Stream.concat(uncommonSecondStream, uncommonFirstStream)
        .collect(Collectors.toList());
    }
}
