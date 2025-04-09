package com.homesystems;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import jakarta.inject.Inject;

@Singleton
class Database {
    private final Map<String, Account> accounts = new HashMap<>();
  
    @Inject
    Database() {
      System.out.println("Creating a new " + this);
    }
  
    Account getAccount(String username) {
      return accounts.computeIfAbsent(username, Account::new);
    }
  
    static final class Account {
      private final String username;
      private BigDecimal balance = BigDecimal.ZERO;
  
      // @Inject
      // Account() {
      //   this.username = "default";
      //   System.out.println("Creating a new () " + this);
      // }

      Account(String username) {
        this.username = username;
        System.out.println("Creating a new (String) " + this);
      }
  
      String username() {
        return username;
      }
  
      BigDecimal balance() {
        return balance;
      }
  
      void deposit(BigDecimal amount) {
        balance = balance.add(amount);
      }
    }
  }