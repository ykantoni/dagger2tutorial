package com.homesystems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import dagger.Module;
import dagger.Provides;
import jakarta.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface MinimumBalance {}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface MaximumWithdrawal {}

@Module
interface AmountsModule {
  @Provides
  @MinimumBalance
  static BigDecimal minimumBalance() {
    return BigDecimal.ZERO;
  }

  @Provides
  @MaximumWithdrawal
  static BigDecimal maximumWithdrawal() {
    return new BigDecimal(100);
  }
}
