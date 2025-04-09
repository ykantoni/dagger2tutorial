package com.homesystems;

import java.math.BigDecimal;
import com.homesystems.Database.Account;
import jakarta.inject.Inject;

final class DepositCommand extends BigDecimalCommand {
  private final Account account;
  private final Outputter outputter;

  @Inject
  DepositCommand(Account account, Outputter outputter) {
    super(outputter);
    this.account = account;
    this.outputter = outputter;
    System.out.println("Creating a new " + this);
  }

  @Override
  public void handleAmount(BigDecimal amount) {
    account.deposit(amount);
    outputter.output(account.username() + " now has: " + account.balance());
  }
}
