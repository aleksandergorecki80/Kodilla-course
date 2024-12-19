package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.function.IntFunction;
import java.util.function.Predicate;

public class StreamMain {
  public static void main(String[] args) {

    Processor processor = new Processor();
    processor.execute(() -> System.out.println("This is an example text."));

    ExpressionExecutor expressionExecutor = new ExpressionExecutor();

    System.out.println("Calculating expressions with lambdas");
    expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
    expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
    expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
    expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

    System.out.println("Calculating expressions with method references");
    expressionExecutor.executeExpression(10, 5, FunctionalCalculator::addAToB);
    expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiplyAByB);
    expressionExecutor.executeExpression(10, 5, FunctionalCalculator::subBFromA);
    expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divideAByB);

    System.out.println("=== Beautifying texts ===");
    PoemBeautifier poemBeautifier = new PoemBeautifier();

    String upperCaseText = poemBeautifier.beautify("text example", text -> text.toUpperCase());
    System.out.println(upperCaseText);

    String addAbc = poemBeautifier.beautify("text example", text -> "ABC " + text + " ABC");
    System.out.println(addAbc);

    String replace = poemBeautifier.beautify("text example", text -> text.replaceAll("text", "poem"));
    System.out.println(replace);

    String stars = poemBeautifier.beautify("text example", text -> "  *************\n" + "| " + text +  " |" + "\n  *************");
    System.out.println(stars);

    System.out.println("Using Stream to generate even numbers from 1 to 20");
    NumbersGenerator.generateEven(20);
  }
}

