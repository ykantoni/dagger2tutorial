package com.homesystems;

import java.util.List;

import javax.inject.Inject;

final class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    HelloWorldCommand(Outputter outputter) {
      this.outputter = outputter;
      System.out.println("Creating a new " + this);
    }
  
    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output("world!");
        return Result.handled();
    }
  }
