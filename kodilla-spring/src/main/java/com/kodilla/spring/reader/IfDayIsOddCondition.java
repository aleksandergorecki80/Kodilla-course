package com.kodilla.spring.reader;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import java.time.LocalDate;

public class IfDayIsOddCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    String result = context.getEnvironment().getProperty("os.name");
    System.out.println(result);
    return LocalDate.now().getDayOfMonth() % 2 != 0;
  }
}