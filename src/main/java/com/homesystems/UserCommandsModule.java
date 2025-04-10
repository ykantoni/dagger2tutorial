package com.homesystems;

import dagger.Module;
import dagger.Binds;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class UserCommandsModule {
  @Binds
  @IntoMap
  @StringKey("deposit")
  abstract Command depositCommand(DepositCommand command);

  @Binds
  @IntoMap
  @StringKey("withdraw")
  abstract Command withdrawCommand(WithdrawCommand command);

  @Binds
  @IntoMap
  @StringKey("logout")
  abstract Command logout(LogoutCommand command);    
}
