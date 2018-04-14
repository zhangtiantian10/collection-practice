package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
      int radNumber = random.nextInt(3);
      List<Integer> results = new ArrayList<>();
      for (int i = number - radNumber; i >= 0; i -= radNumber) {
        results.add(i);
      }

      return results;
    }
}
