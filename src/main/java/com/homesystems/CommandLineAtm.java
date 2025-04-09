package com.homesystems;

import java.util.Scanner;
import com.homesystems.Command.Status;

  class CommandLineAtm {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      CommandProcessorFactory commandProcessorFactory = DaggerCommandProcessorFactory.create();
      CommandProcessor commandProcessor = commandProcessorFactory.commandProcessor();
  
      while (scanner.hasNextLine()) {
        Status unused = commandProcessor.process(scanner.nextLine());
        System.out.println(unused);
      }
      scanner.close();
    }
  }