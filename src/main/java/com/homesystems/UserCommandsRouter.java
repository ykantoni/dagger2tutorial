package com.homesystems;

import com.homesystems.Database.Account;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@Subcomponent(modules = UserCommandsModule.class)
interface UserCommandsRouter {
  
  CommandRouter router();

  @Subcomponent.Factory
  interface Factory {
    UserCommandsRouter create(@BindsInstance Account account);
  }

  @Module(subcomponents = UserCommandsRouter.class)
  interface InstallationModule {}
}
