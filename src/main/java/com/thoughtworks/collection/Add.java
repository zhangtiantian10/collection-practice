package com.thoughtworks.collection;

import com.github.underscore.Tuple;
import com.sun.xml.internal.ws.util.StreamUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
  public int getSumOfEvens(int leftBorder, int rightBorder) {
    List<Integer> numbers = getNumbers(leftBorder, rightBorder, 2);

    return numbers.stream()
      .reduce(0, (sum, n) -> sum + n);
  }

  private List<Integer> getNumbers(int leftBorder, int rightBorder, int type) {
    List<Integer> numbers = new ArrayList<>();
    int max = leftBorder > rightBorder ? leftBorder : rightBorder;
    int min = leftBorder > rightBorder ? rightBorder : leftBorder;

    for (int i = min; i <= max; i++) {
      if (i % 2 == 0 && type == 2) {
        numbers.add(i);
      } else if (i % 2 != 0 && type == 1) {
        numbers.add(i);
      }
    }

    return numbers;
  }

  public int getSumOfOdds(int leftBorder, int rightBorder) {
    List<Integer> numbers = getNumbers(leftBorder, rightBorder, 1);

    return numbers.stream()
      .reduce(0, (sum, n) -> sum + n);
  }

  public int getSumTripleAndAddTwo(List<Integer> arrayList) {
    return arrayList.stream()
      .reduce(0, (sum, number) -> sum + (number * 3 + 2));
  }

  public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
    return arrayList.stream()
      .map(number -> number % 2 == 0 ? number : number * 3 + 2)
      .collect(Collectors.toList());
  }

  public int getSumOfProcessedOdds(List<Integer> arrayList) {
    return arrayList.stream()
      .reduce(0, (sum, number) -> number % 2 == 0 ? sum : sum + number * 3 + 5);
  }

  public double getMedianOfEvenIndex(List<Integer> arrayList) {
    return arrayList.stream()
      .filter(number -> number % 2 == 0)
      .reduce(0, (sum, number) -> sum + number) / 2;
  }

  public double getAverageOfEvenIndex(List<Integer> arrayList) {
    List<Integer> numbers = arrayList.stream()
      .filter(number -> number % 2 == 0)
      .collect(Collectors.toList());
    return numbers.stream()
      .reduce(0, (sum, number) -> sum + number) / numbers.size();
  }

  public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
    Optional optional = arrayList.stream()
      .filter(integer -> integer == specialElment && specialElment % 2 == 0)
      .findFirst();

    return optional.isPresent();
  }

  public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
    Set evens = arrayList.stream()
      .filter(number -> number % 2 == 0)
      .collect(Collectors.toSet());

    return (List<Integer>) evens.stream().collect(Collectors.toList());
  }

  public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
    Stream<Integer> evenStream = arrayList.stream().filter(integer -> integer % 2 == 0);
    Stream<Integer> oldStream = arrayList.stream().filter(integer -> integer % 2 != 0);
    Stream<Integer> sortedEvenStream = evenStream.sorted();
    Stream<Integer> sortedOldStream = oldStream.sorted(Comparator.reverseOrder());
    Stream<Integer> resultStream = Stream.concat(sortedEvenStream, sortedOldStream);
    return resultStream.collect(Collectors.toList());
  }

  public List<Integer> getProcessedList(List<Integer> arrayList) {
    List<Integer> tempStream = arrayList.stream().skip(1).collect(Collectors.toList());
    Stream<Integer> arrayStream = arrayList.stream();
    return IntStream.range(0, Math.min(tempStream.size(), arrayList.size())).map(i -> (tempStream.get(i) + arrayList.get(i)) * 3).boxed().collect(Collectors.toList());
  }
}
