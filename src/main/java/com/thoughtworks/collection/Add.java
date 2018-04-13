package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        } else if (i % 2 != 0 && type == 1){
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
        .reduce(0 , (sum, number) -> sum + number) / 2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
