package com.thoughtworks.collection;

import java.util.Comparator;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
          .min(Comparator.reverseOrder()).get();
    }

    public double getMinimum() {
      return arrayList.stream()
        .max(Comparator.reverseOrder()).get();
    }

    public double getAverage() {
      int number = arrayList.stream()
        .reduce(0, (sum, item) -> sum + item);

      return (double) number / arrayList.size();
    }

    public double getOrderedMedian() {
      int size = arrayList.size();

        if (size % 2 == 0) {
          return (double) (arrayList.get(size / 2 - 1) + arrayList.get(size / 2)) / 2;
        } else {
          return arrayList.get(size / 2);
        }
    }

    public int getFirstEven() {
      return arrayList.stream()
        .filter(item -> item % 2 == 0)
        .findFirst().get();
    }

    public int getIndexOfFirstEven() {
      int even = getFirstEven();

      return arrayList.indexOf(even);
    }

    public boolean isEqual(List<Integer> arrayList) {
      return this.arrayList.equals(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
      for(int i=0; i<arrayList.size(); i++){

        singleLink.addTailPointer(arrayList.get(i));
      }

      int index = arrayList.size()/2;

      if(arrayList.size()%2 == 0){
        return ((Integer) singleLink.getNode(index) + (Integer) singleLink.getNode(index+1))/2.0;
      }else{
        return (Double) singleLink.getNode(index+1);
      }
    }

    public int getLastOdd() {
        return arrayList.stream()
          .filter(item -> item % 2 != 0)
          .reduce((a, b) -> b).get();
    }

    public int getIndexOfLastOdd() {
      int lastOdd = getLastOdd();

      return arrayList.lastIndexOf(lastOdd);
    }
}
