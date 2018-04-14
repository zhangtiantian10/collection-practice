package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
