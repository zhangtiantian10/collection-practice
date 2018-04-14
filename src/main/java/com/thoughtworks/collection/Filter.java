package com.thoughtworks.collection;

import com.google.common.primitives.Ints;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
      return array.stream()
        .filter(item -> item % 2 == 0)
        .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
      return array.stream()
        .filter(item -> item % 3 == 0)
        .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
      int[] arrayInt = toIntArray((Integer[]) secondList.toArray());
      return firstList.stream()
        .filter(item -> Ints.contains(arrayInt, item))
        .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return array.stream()
          .distinct()
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