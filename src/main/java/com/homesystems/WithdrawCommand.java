package com.homesystems;

import java.math.BigDecimal;

import com.homesystems.Database.Account;

import jakarta.inject.Inject;

final class WithdrawCommand extends BigDecimalCommand {
    
   final Outputter outputter;
   final Account account;
   final BigDecimal minimumBalance;
   final BigDecimal maximumWithdrawal;
  
    @Inject
    WithdrawCommand(Outputter outputter,
        Account account,
        @MinimumBalance BigDecimal minimumBalance,
        @MaximumWithdrawal BigDecimal maximumWithdrawal) { 
        super(outputter);
        this.outputter = outputter;
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
        System.out.println("Creating a new " + this);
    }
  
    @Override
    public void handleAmount(BigDecimal amount) {
      if (amount.compareTo(maximumWithdrawal) > 0) {
        System.out.println("Canceled - trying to withdraw more than " + maximumWithdrawal);
      } else {
        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
          System.out.println("Canceled - minimum balamce must be " + minimumBalance);
        } else {
          account.withdraw(amount);
        }
      }
      outputter.output("your new balance is: " + account.balance());
    }
  }
