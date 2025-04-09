package com.homesystems;

import javax.inject.Inject;

import com.homesystems.Database.Account;

final class LoginCommand extends SingleArgCommand {
  private final Database database;
  private final Outputter outputter;
  private final UserCommandsRouter.Factory userCommandsRouterFactory;

  @Inject
  LoginCommand(
      Database database,
      Outputter outputter,
      UserCommandsRouter.Factory userCommandsRouterFactory) {
    this.database = database;
    this.outputter = outputter;
    this.userCommandsRouterFactory = userCommandsRouterFactory;
    System.out.println("Creating a new " + this);
  }

  @Override
  public Result handleArg(String username) {
    Account account = database.getAccount(username);
    outputter.output(
        username + " is logged in with balance: " + account.balance());
    return Result.enterNestedCommandSet(
        userCommandsRouterFactory.create(account).router());
  }
}
