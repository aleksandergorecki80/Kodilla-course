package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OddNumbersExterminator {

  public List<Integer> exterminate(List<Integer> numbers){
    if (numbers.isEmpty()){
      return null;
    }
    List<Integer> result = new ArrayList<Integer>();
    for (Integer number : numbers) {
      if (number % 2 == 0) {
        result.add(number);
      }
    }
    return result;
  }

}
