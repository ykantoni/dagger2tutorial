package com.homesystems;

import java.util.List;
import javax.inject.Inject;

public class LogoutCommand implements Command{

  private final Outputter outputter;
  
  @Inject
  LogoutCommand(Outputter outputter) {
    this.outputter = outputter;
    outputter.output("Creating a new " + this);
  }

  @Override
  public Result handleInput(List<String> input) { 
   return input.isEmpty() ? Result.inputCompleted() : Result.invalid();
  }

}
