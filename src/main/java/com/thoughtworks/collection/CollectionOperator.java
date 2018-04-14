package com.thoughtworks.collection;

import com.google.common.primitives.Ints;

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
      return Arrays.stream(firstArray)
        .boxed()
        .filter(item -> Ints.contains(secondArray, item))
        .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
      int[] firstIntArray = toIntArray(firstArray);
      Stream<Integer> uncommonStream = Arrays.stream(secondArray)
        .filter(item -> !Ints.contains(firstIntArray, item.intValue()));
      return Stream.concat(Arrays.stream(firstArray), uncommonStream)
        .collect(Collectors.toList());
    }

  static int[] toIntArray(Integer[] integerArray) {
    int[] intArray = new int[integerArray.length];
    for (int i = 0; i < integerArray.length; i++) {
      intArray[i] = integerArray[i];
    }
    return intArray;
  }
}
