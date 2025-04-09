package com.homesystems;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
    modules = {
      LoginCommandModule.class,
      HelloWorldModule.class,
      SystemOutModule.class,
      UserCommandsRouter.InstallationModule.class
    })
interface CommandProcessorFactory {
  CommandProcessor commandProcessor();
}