package com.homesystems;

import java.util.List;
import java.util.Optional;

/** Logic to process some user input. */
interface Command {
  Result handleInput(List<String> input);

  final class Result {
    private final Status status;
    private final Optional<CommandRouter> nestedCommandRouter;

    private Result(Status status, Optional<CommandRouter> nestedCommandRouter) {
      this.status = status;
      this.nestedCommandRouter = nestedCommandRouter;
    }

    static Result invalid() {
      return new Result(Status.INVALID, Optional.empty());
    }

    static Result handled() {
      return new Result(Status.HANDLED, Optional.empty());
    }

    Status status() {
      return status;
    }

    Optional<CommandRouter> nestedCommandRouter() {
      return nestedCommandRouter;
    }

    static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
      return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
    }
  }

  enum Status {
    INVALID,
    HANDLED,
    INPUT_COMPLETED
  }
}
