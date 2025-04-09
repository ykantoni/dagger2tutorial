package com.homesystems;

import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import dagger.Binds;

@Module
abstract class LoginCommandModule {
  @Binds
  @IntoMap
  @StringKey("login")
  abstract Command loginCommand(LoginCommand command);
}
